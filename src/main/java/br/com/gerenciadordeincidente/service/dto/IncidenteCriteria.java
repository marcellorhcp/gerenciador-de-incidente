package br.com.gerenciadordeincidente.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import br.com.gerenciadordeincidente.domain.enumeration.Status;
import br.com.gerenciadordeincidente.domain.enumeration.Impacto;
import br.com.gerenciadordeincidente.domain.enumeration.Categoria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;

/**
 * Criteria class for the {@link br.com.gerenciadordeincidente.domain.Incidente} entity. This class is used
 * in {@link br.com.gerenciadordeincidente.web.rest.IncidenteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /incidentes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class IncidenteCriteria implements Serializable, Criteria {
    /**
     * Class for filtering Status
     */
    public static class StatusFilter extends Filter<Status> {

        public StatusFilter() {
        }

        public StatusFilter(StatusFilter filter) {
            super(filter);
        }

        @Override
        public StatusFilter copy() {
            return new StatusFilter(this);
        }

    }
    /**
     * Class for filtering Impacto
     */
    public static class ImpactoFilter extends Filter<Impacto> {

        public ImpactoFilter() {
        }

        public ImpactoFilter(ImpactoFilter filter) {
            super(filter);
        }

        @Override
        public ImpactoFilter copy() {
            return new ImpactoFilter(this);
        }

    }
    /**
     * Class for filtering Categoria
     */
    public static class CategoriaFilter extends Filter<Categoria> {

        public CategoriaFilter() {
        }

        public CategoriaFilter(CategoriaFilter filter) {
            super(filter);
        }

        @Override
        public CategoriaFilter copy() {
            return new CategoriaFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StatusFilter status;

    private ImpactoFilter impacto;

    private StringFilter solicitante;

    private CategoriaFilter categoria;

    private InstantFilter dataAbertura;

    private LongFilter userId;

    public IncidenteCriteria() {
    }

    public IncidenteCriteria(IncidenteCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.status = other.status == null ? null : other.status.copy();
        this.impacto = other.impacto == null ? null : other.impacto.copy();
        this.solicitante = other.solicitante == null ? null : other.solicitante.copy();
        this.categoria = other.categoria == null ? null : other.categoria.copy();
        this.dataAbertura = other.dataAbertura == null ? null : other.dataAbertura.copy();
        this.userId = other.userId == null ? null : other.userId.copy();
    }

    @Override
    public IncidenteCriteria copy() {
        return new IncidenteCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StatusFilter getStatus() {
        return status;
    }

    public void setStatus(StatusFilter status) {
        this.status = status;
    }

    public ImpactoFilter getImpacto() {
        return impacto;
    }

    public void setImpacto(ImpactoFilter impacto) {
        this.impacto = impacto;
    }

    public StringFilter getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(StringFilter solicitante) {
        this.solicitante = solicitante;
    }

    public CategoriaFilter getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilter categoria) {
        this.categoria = categoria;
    }

    public InstantFilter getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(InstantFilter dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LongFilter getUserId() {
        return userId;
    }

    public void setUserId(LongFilter userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IncidenteCriteria that = (IncidenteCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(status, that.status) &&
            Objects.equals(impacto, that.impacto) &&
            Objects.equals(solicitante, that.solicitante) &&
            Objects.equals(categoria, that.categoria) &&
            Objects.equals(dataAbertura, that.dataAbertura) &&
            Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        status,
        impacto,
        solicitante,
        categoria,
        dataAbertura,
        userId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IncidenteCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (status != null ? "status=" + status + ", " : "") +
                (impacto != null ? "impacto=" + impacto + ", " : "") +
                (solicitante != null ? "solicitante=" + solicitante + ", " : "") +
                (categoria != null ? "categoria=" + categoria + ", " : "") +
                (dataAbertura != null ? "dataAbertura=" + dataAbertura + ", " : "") +
                (userId != null ? "userId=" + userId + ", " : "") +
            "}";
    }

}
