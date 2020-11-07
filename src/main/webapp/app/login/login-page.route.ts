import { Route } from '@angular/router';

import { LoginPageComponent } from './login-page.component';

export const LOGIN_PAGE_ROUTE: Route = {
  path: 'login',
  component: LoginPageComponent,
  data: {
    authorities: [],
    pageTitle: 'login.title'
  }
};