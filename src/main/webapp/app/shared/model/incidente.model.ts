import { Moment } from 'moment';
import { IUser } from 'app/core/user/user.model';
import { Status } from 'app/shared/model/enumerations/status.model';
import { Impacto } from 'app/shared/model/enumerations/impacto.model';
import { Categoria } from 'app/shared/model/enumerations/categoria.model';

export interface IIncidente {
  id?: number;
  descricao?: any;
  status?: Status;
  impacto?: Impacto;
  solicitante?: string;
  categoria?: Categoria;
  dataAbertura?: Moment;
  user?: IUser;
}

export class Incidente implements IIncidente {
  constructor(
    public id?: number,
    public descricao?: any,
    public status?: Status,
    public impacto?: Impacto,
    public solicitante?: string,
    public categoria?: Categoria,
    public dataAbertura?: Moment,
    public user?: IUser
  ) {}
}
