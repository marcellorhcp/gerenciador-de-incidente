import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiDataUtils } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IIncidente } from 'app/shared/model/incidente.model';
import { IncidenteService } from './incidente.service';
import { IncidenteDeleteDialogComponent } from './incidente-delete-dialog.component';

@Component({
  selector: 'jhi-incidente',
  templateUrl: './incidente.component.html',
})
export class IncidenteComponent implements OnInit, OnDestroy {
  incidentes?: IIncidente[];
  eventSubscriber?: Subscription;

  constructor(
    protected incidenteService: IncidenteService,
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.incidenteService.query().subscribe((res: HttpResponse<IIncidente[]>) => (this.incidentes = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInIncidentes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IIncidente): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    return this.dataUtils.openFile(contentType, base64String);
  }

  registerChangeInIncidentes(): void {
    this.eventSubscriber = this.eventManager.subscribe('incidenteListModification', () => this.loadAll());
  }

  delete(incidente: IIncidente): void {
    const modalRef = this.modalService.open(IncidenteDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.incidente = incidente;
  }
}
