import {
  HttpErrorResponse,
  HttpInterceptorFn,
  HttpResponse,
} from '@angular/common/http';
import { inject } from '@angular/core';
import {
  catchError,
  of,
  tap,
  throwError,
} from 'rxjs';

import { HttpResponseCacheService } from '../services/http-response-cache.service';
import { ServiceAvailabilityService } from '../services/service-availability.service';

const UNAVAILABLE_STATUSES = new Set([0, 502, 503, 504]);

export const resilienceInterceptor: HttpInterceptorFn = (req, next) => {
  const cache = inject(HttpResponseCacheService);
  const availability = inject(ServiceAvailabilityService);

  return next(req).pipe(
    tap(event => {
      if (event instanceof HttpResponse) {
        cache.put(req, event);
      }
    }),
    catchError(error => {
      if (error instanceof HttpErrorResponse && UNAVAILABLE_STATUSES.has(error.status)) {
        const cachedResponse = cache.get(req);
        availability.showUnavailable(resolveServiceName(req.url), Boolean(cachedResponse));

        if (cachedResponse) {
          return of(cachedResponse);
        }
      }

      return throwError(() => error);
    }),
  );
};

function resolveServiceName(url: string): string {
  if (url.includes('/teachsync/users')) {
    return 'Users service';
  }
  if (url.includes('/teachsync/auth') || url.includes('/teachsync/account')) {
    return 'Auth service';
  }
  if (
    url.includes('/teachsync/courses')
    || url.includes('/teachsync/groups')
    || url.includes('/teachsync/topics')
    || url.includes('/teachsync/categories')
  ) {
    return 'Course service';
  }
  if (url.includes('/teachsync/schedules') || url.includes('/teachsync/classrooms')) {
    return 'Schedule service';
  }
  if (url.includes('/teachsync/replacements')) {
    return 'Replacement service';
  }
  if (url.includes('/teachsync/notifications')) {
    return 'Notification service';
  }

  return 'Backend service';
}
