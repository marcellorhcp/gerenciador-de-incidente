import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GerenciadorDeIncidenteSharedModule } from 'app/shared/shared.module';
import { HOME_ROUTE } from './home.route';
@NgModule({
  imports: [GerenciadorDeIncidenteSharedModule, RouterModule.forChild([HOME_ROUTE])]
})
export class GerenciadorDeIncidenteHomeModule {}
