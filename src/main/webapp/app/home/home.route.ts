import { Route } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IncidenteComponent } from 'app/entities/incidente/incidente.component';
import { Authority } from 'app/shared/constants/authority.constants';

export const HOME_ROUTE: Route =  {
  path: '',
  component: IncidenteComponent,
  data: {
    authorities: [Authority.USER],
    pageTitle: 'gerenciadorDeIncidenteApp.incidente.home.title',
  },
  canActivate: [UserRouteAccessService],
};
