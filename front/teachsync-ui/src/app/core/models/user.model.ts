
/* user model dto example for sers list*/ 
export interface User {
    id: number;
    fullName: string;
    email: string;
    registeredAt: string;
    role: 'ADMIN' | 'MANAGER' | 'TEACHER';
}