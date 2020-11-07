import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { IIncidente } from 'app/shared/model/incidente.model';

@Component({
  selector: 'jhi-incidente-detail',
  templateUrl: './incidente-detail.component.html',
})
export class IncidenteDetailComponent implements OnInit {
  incidente: IIncidente | null = null;

  constructor(protected dataUtils: JhiDataUtils, protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ incidente }) => (this.incidente = incidente));
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType = '', base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  previousState(): void {
    window.history.back();
  }
}
