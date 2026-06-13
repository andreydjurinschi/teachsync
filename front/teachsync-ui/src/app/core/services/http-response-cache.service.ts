import { isPlatformBrowser } from '@angular/common';
import { HttpRequest, HttpResponse } from '@angular/common/http';
import { Inject, Injectable, PLATFORM_ID } from '@angular/core';

interface CachedHttpResponse {
  body: unknown;
  cachedAt: number;
  status: number;
  statusText: string;
  url: string;
}

@Injectable({ providedIn: 'root' })
export class HttpResponseCacheService {
  private readonly prefix = 'teachsync_http_cache:';
  private readonly maxEntries = 120;

  constructor(@Inject(PLATFORM_ID) private platformId: object) {}

  put(req: HttpRequest<unknown>, response: HttpResponse<unknown>): void {
    if (!this.canUseCache(req) || response.body === null) {
      return;
    }

    const entry: CachedHttpResponse = {
      body: response.body,
      cachedAt: Date.now(),
      status: response.status,
      statusText: response.statusText,
      url: response.url ?? req.urlWithParams,
    };

    try {
      localStorage.setItem(this.buildKey(req), JSON.stringify(entry));
      this.trimCache();
    } catch {
      this.clearOldestEntry();
    }
  }

  get(req: HttpRequest<unknown>): HttpResponse<unknown> | null {
    if (!this.canUseCache(req)) {
      return null;
    }

    try {
      const raw = localStorage.getItem(this.buildKey(req));
      if (!raw) {
        return null;
      }

      const entry = JSON.parse(raw) as CachedHttpResponse;
      return new HttpResponse({
        body: entry.body,
        status: entry.status || 200,
        statusText: entry.statusText || 'OK',
        url: entry.url || req.urlWithParams,
      });
    } catch {
      return null;
    }
  }

  private canUseCache(req: HttpRequest<unknown>): boolean {
    return isPlatformBrowser(this.platformId)
      && req.method === 'GET'
      && req.responseType === 'json';
  }

  private buildKey(req: HttpRequest<unknown>): string {
    return `${this.prefix}${encodeURIComponent(`${this.currentUserScope()}|${req.urlWithParams}`)}`;
  }

  private currentUserScope(): string {
    try {
      const token = localStorage.getItem('jwt_token');
      if (!token) {
        return 'anonymous';
      }

      const payload = JSON.parse(atob(token.split('.')[1])) as Record<string, unknown>;
      return [
        payload['userId'] ?? 'unknown',
        payload['roles'] ?? 'unknown',
        payload['email'] ?? 'unknown',
      ].join(':');
    } catch {
      return 'unknown-user';
    }
  }

  private trimCache(): void {
    const entries = this.cacheEntries();
    if (entries.length <= this.maxEntries) {
      return;
    }

    entries
      .sort((left, right) => left.cachedAt - right.cachedAt)
      .slice(0, entries.length - this.maxEntries)
      .forEach(entry => localStorage.removeItem(entry.key));
  }

  private clearOldestEntry(): void {
    const oldest = this.cacheEntries().sort((left, right) => left.cachedAt - right.cachedAt)[0];
    if (oldest) {
      localStorage.removeItem(oldest.key);
    }
  }

  private cacheEntries(): Array<{ key: string; cachedAt: number }> {
    const entries: Array<{ key: string; cachedAt: number }> = [];

    for (let index = 0; index < localStorage.length; index += 1) {
      const key = localStorage.key(index);
      if (!key?.startsWith(this.prefix)) {
        continue;
      }

      try {
        const raw = localStorage.getItem(key);
        const parsed = raw ? JSON.parse(raw) as CachedHttpResponse : null;
        entries.push({ key, cachedAt: parsed?.cachedAt ?? 0 });
      } catch {
        entries.push({ key, cachedAt: 0 });
      }
    }

    return entries;
  }
}
