import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IIncidente, Incidente } from 'app/shared/model/incidente.model';
import { IncidenteService } from './incidente.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import { IUser } from 'app/core/user/user.model';
import { UserService } from 'app/core/user/user.service';

@Component({
  selector: 'jhi-incidente-update',
  templateUrl: './incidente-update.component.html',
})
export class IncidenteUpdateComponent implements OnInit {
  isSaving = false;
  users: IUser[] = [];

  editForm = this.fb.group({
    id: [],
    descricao: [],
    status: [],
    impacto: [],
    solicitante: [],
    categoria: [],
    dataAbertura: [],
    user: [],
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected incidenteService: IncidenteService,
    protected userService: UserService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ incidente }) => {
      if (!incidente.id) {
        const today = moment().startOf('day');
        incidente.dataAbertura = today;
      }

      this.updateForm(incidente);

      this.userService.query().subscribe((res: HttpResponse<IUser[]>) => (this.users = res.body || []));
    });
  }

  updateForm(incidente: IIncidente): void {
    this.editForm.patchValue({
      id: incidente.id,
      descricao: incidente.descricao,
      status: incidente.status,
      impacto: incidente.impacto,
      solicitante: incidente.solicitante,
      categoria: incidente.categoria,
      dataAbertura: incidente.dataAbertura ? incidente.dataAbertura.format(DATE_TIME_FORMAT) : null,
      user: incidente.user,
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  setFileData(event: any, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe(null, (err: JhiFileLoadError) => {
      this.eventManager.broadcast(
        new JhiEventWithContent<AlertError>('gerenciadorDeIncidenteApp.error', { ...err, key: 'error.file.' + err.key })
      );
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const incidente = this.createFromForm();
    if (incidente.id !== undefined) {
      this.subscribeToSaveResponse(this.incidenteService.update(incidente));
    } else {
      this.subscribeToSaveResponse(this.incidenteService.create(incidente));
    }
  }

  private createFromForm(): IIncidente {
    return {
      ...new Incidente(),
      id: this.editForm.get(['id'])!.value,
      descricao: this.editForm.get(['descricao'])!.value,
      status: this.editForm.get(['status'])!.value,
      impacto: this.editForm.get(['impacto'])!.value,
      solicitante: this.editForm.get(['solicitante'])!.value,
      categoria: this.editForm.get(['categoria'])!.value,
      dataAbertura: this.editForm.get(['dataAbertura'])!.value
        ? moment(this.editForm.get(['dataAbertura'])!.value, DATE_TIME_FORMAT)
        : undefined,
      user: this.editForm.get(['user'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IIncidente>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IUser): any {
    return item.id;
  }
}
