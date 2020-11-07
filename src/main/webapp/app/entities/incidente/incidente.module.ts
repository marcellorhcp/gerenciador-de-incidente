import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GerenciadorDeIncidenteSharedModule } from 'app/shared/shared.module';
import { IncidenteComponent } from './incidente.component';
import { IncidenteDetailComponent } from './incidente-detail.component';
import { IncidenteUpdateComponent } from './incidente-update.component';
import { IncidenteDeleteDialogComponent } from './incidente-delete-dialog.component';
import { incidenteRoute } from './incidente.route';

@NgModule({
  imports: [GerenciadorDeIncidenteSharedModule, RouterModule.forChild(incidenteRoute)],
  declarations: [IncidenteComponent, IncidenteDetailComponent, IncidenteUpdateComponent, IncidenteDeleteDialogComponent],
  entryComponents: [IncidenteDeleteDialogComponent],
})
export class GerenciadorDeIncidenteIncidenteModule {}
