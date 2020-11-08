package br.com.gerenciadordeincidente.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;

import br.com.gerenciadordeincidente.domain.enumeration.Status;
import br.com.gerenciadordeincidente.domain.enumeration.Urgencia;
import br.com.gerenciadordeincidente.domain.enumeration.Impacto;

import br.com.gerenciadordeincidente.domain.enumeration.Categoria;

/**
 * A Incidente.
 */
@Entity
@Table(name = "incidente")
public class Incidente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Lob
	@Column(name = "descricao")
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "impacto")
	private Impacto impacto;

	@Column(name = "solicitante")
	private String solicitante;

	@Enumerated(EnumType.STRING)
	@Column(name = "categoria")
	private Categoria categoria;

	@Column(name = "data_abertura")
	private Instant dataAbertura;

	@ManyToOne
	@JsonIgnoreProperties(value = "incidentes", allowSetters = true)
	private User user;

	// jhipster-needle-entity-add-field - JHipster will add fields here
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Incidente descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public Incidente status(Status status) {
		this.status = status;
		return this;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Impacto getImpacto() {
		return impacto;
	}

	public Incidente impacto(Impacto impacto) {
		this.impacto = impacto;
		return this;
	}

	public void setImpacto(Impacto impacto) {
		this.impacto = impacto;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public Incidente solicitante(String solicitante) {
		this.solicitante = solicitante;
		return this;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Incidente categoria(Categoria categoria) {
		this.categoria = categoria;
		return this;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Instant getDataAbertura() {
		return dataAbertura;
	}

	public Incidente dataAbertura(Instant dataAbertura) {
		this.dataAbertura = dataAbertura;
		return this;
	}

	public void setDataAbertura(Instant dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public User getUser() {
		return user;
	}

	public Incidente user(User user) {
		this.user = user;
		return this;
	}

	public void setUser(User user) {
		this.user = user;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Incidente)) {
			return false;
		}
		return id != null && id.equals(((Incidente) o).id);
	}

	public int getPrioridade() {
		if (this.impacto.equals(Impacto.ALTA) && this.categoria.getUrgencia().equals(Urgencia.ALTA)) {
			return 1;
		} else if ((this.impacto.equals(Impacto.ALTA) && this.categoria.getUrgencia().equals(Urgencia.MEDIA))
				|| (this.impacto.equals(Impacto.ALTA) && this.categoria.getUrgencia().equals(Urgencia.BAIXA))
				|| (this.impacto.equals(Impacto.MEDIA) && this.categoria.getUrgencia().equals(Urgencia.ALTA))
				|| (this.impacto.equals(Impacto.MEDIA) && this.categoria.getUrgencia().equals(Urgencia.MEDIA))
				|| (this.impacto.equals(Impacto.BAIXA) && this.categoria.getUrgencia().equals(Urgencia.ALTA))) {
			return 2;
		}
		return 3;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	// prettier-ignore
	@Override
	public String toString() {
		return "Incidente{" + "id=" + getId() + ", descricao='" + getDescricao() + "'" + ", status='" + getStatus()
				+ "'" + ", impacto='" + getImpacto() + "'" + ", solicitante='" + getSolicitante() + "'"
				+ ", categoria='" + getCategoria() + "'" + ", dataAbertura='" + getDataAbertura() + "'" + "}";
	}
}
