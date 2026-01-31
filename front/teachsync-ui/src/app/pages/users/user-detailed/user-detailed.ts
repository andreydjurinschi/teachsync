import { CommonModule } from "@angular/common";
import { Component, OnInit, signal } from "@angular/core";
import { User } from "../../../core/models/users/user.model";
import { UserService } from "../../../core/services/user.service";
import { ActivatedRoute, RouterLink } from "@angular/router";

@Component({
    selector: 'app-user-detailed',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './user-detailed.html',
})
export class UserDetailed implements OnInit{
    
    user = signal<User | null>(null);
    loading = signal<boolean>(false);   
    
    constructor(
        private route: ActivatedRoute,
        private userService: UserService
    ) {
    }

    ngOnInit(): void {
        const userId   = Number(this.route.snapshot.paramMap.get('id'));
        this.loadUser(userId);
    }

    loadUser(id: number): void {
        this.loading.set(true);
        this.userService.getById(id).subscribe({
            next: data => this.user.set(data),
            error: err => {
                console.error(err);
                this.user.set(null);
            },
            complete: () => this.loading.set(false)
        })
    }
}