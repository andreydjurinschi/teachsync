import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';

import { ServiceAvailabilityService } from '../../core/services/service-availability.service';

@Component({
  selector: 'app-service-unavailable-modal',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div
      *ngIf="availability.notice() as notice"
      class="fixed inset-0 z-[100] flex items-center justify-center bg-slate-950/50 px-4"
      role="dialog"
      aria-modal="true"
      aria-labelledby="service-unavailable-title">
      <div class="w-full max-w-md rounded-md border border-slate-200 bg-white p-5 shadow-xl dark:border-slate-700 dark:bg-slate-900">
        <div class="mb-4 flex items-start gap-3">
          <div class="flex h-10 w-10 shrink-0 items-center justify-center rounded-md border border-amber-200 bg-amber-50 text-amber-700 dark:border-amber-900/70 dark:bg-amber-950/30 dark:text-amber-300">
            <svg class="h-5 w-5" fill="none" stroke="currentColor" stroke-width="2" viewBox="0 0 24 24">
              <path stroke-linecap="round" stroke-linejoin="round" d="M12 9v4m0 4h.01M10.29 3.86 1.82 18a2 2 0 0 0 1.71 3h16.94a2 2 0 0 0 1.71-3L13.71 3.86a2 2 0 0 0-3.42 0z" />
            </svg>
          </div>

          <div class="min-w-0">
            <h2 id="service-unavailable-title" class="text-base font-semibold text-slate-950 dark:text-white">
              Сервис временно недоступен
            </h2>
            <p class="mt-1 text-sm leading-6 text-slate-600 dark:text-slate-300">
              {{ notice.serviceName }} сейчас не отвечает.
              <ng-container *ngIf="notice.usesCache; else noCache">
                На странице показаны последние сохраненные данные из кеша.
              </ng-container>
              <ng-template #noCache>
                Кешированных данных для этого запроса пока нет.
              </ng-template>
            </p>
          </div>
        </div>

        <div class="flex justify-end">
          <button type="button" class="app-btn-primary" (click)="availability.close()">
            Понятно
          </button>
        </div>
      </div>
    </div>
  `,
})
export class ServiceUnavailableModalComponent {
  protected readonly availability = inject(ServiceAvailabilityService);
}
