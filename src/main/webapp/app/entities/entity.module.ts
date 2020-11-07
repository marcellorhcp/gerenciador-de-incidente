import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'incidente',
        loadChildren: () => import('./incidente/incidente.module').then(m => m.GerenciadorDeIncidenteIncidenteModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class GerenciadorDeIncidenteEntityModule {}
