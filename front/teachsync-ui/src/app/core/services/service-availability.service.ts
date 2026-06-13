import { Injectable, signal } from '@angular/core';

export interface ServiceAvailabilityNotice {
  serviceName: string;
  usesCache: boolean;
}

@Injectable({ providedIn: 'root' })
export class ServiceAvailabilityService {
  private readonly noticeSignal = signal<ServiceAvailabilityNotice | null>(null);
  private lastShownAt = 0;

  readonly notice = this.noticeSignal.asReadonly();

  showUnavailable(serviceName: string, usesCache: boolean): void {
    const now = Date.now();
    if (now - this.lastShownAt < 1200 && this.noticeSignal()) {
      return;
    }

    this.lastShownAt = now;
    this.noticeSignal.set({ serviceName, usesCache });
  }

  close(): void {
    this.noticeSignal.set(null);
  }
}
