import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIncidente } from 'app/shared/model/incidente.model';
import { IncidenteService } from './incidente.service';

@Component({
  templateUrl: './incidente-delete-dialog.component.html',
})
export class IncidenteDeleteDialogComponent {
  incidente?: IIncidente;

  constructor(protected incidenteService: IncidenteService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.incidenteService.delete(id).subscribe(() => {
      this.eventManager.broadcast('incidenteListModification');
      this.activeModal.close();
    });
  }
}
