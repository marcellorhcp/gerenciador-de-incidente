import { Injectable } from '@angular/core';

import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class LoginModalService {
  constructor(private router: Router) {}

  open(): void {
    this.router.navigate(['login']);
  }
}