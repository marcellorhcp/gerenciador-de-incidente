package br.com.gerenciadordeincidente.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import br.com.gerenciadordeincidente.domain.Incidente;
import br.com.gerenciadordeincidente.domain.*; // for static metamodels
import br.com.gerenciadordeincidente.repository.IncidenteRepository;
import br.com.gerenciadordeincidente.service.dto.IncidenteCriteria;

/**
 * Service for executing complex queries for {@link Incidente} entities in the database.
 * The main input is a {@link IncidenteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link Incidente} or a {@link Page} of {@link Incidente} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class IncidenteQueryService extends QueryService<Incidente> {

    private final Logger log = LoggerFactory.getLogger(IncidenteQueryService.class);

    private final IncidenteRepository incidenteRepository;

    public IncidenteQueryService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    /**
     * Return a {@link List} of {@link Incidente} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<Incidente> findByCriteria(IncidenteCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Incidente> specification = createSpecification(criteria);
        return incidenteRepository.findAll(specification);
    }

    /**
     * Return a {@link Page} of {@link Incidente} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Incidente> findByCriteria(IncidenteCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Incidente> specification = createSpecification(criteria);
        return incidenteRepository.findAll(specification, page);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(IncidenteCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Incidente> specification = createSpecification(criteria);
        return incidenteRepository.count(specification);
    }

    /**
     * Function to convert {@link IncidenteCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Incidente> createSpecification(IncidenteCriteria criteria) {
        Specification<Incidente> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Incidente_.id));
            }
            if (criteria.getStatus() != null) {
                specification = specification.and(buildSpecification(criteria.getStatus(), Incidente_.status));
            }
            if (criteria.getImpacto() != null) {
                specification = specification.and(buildSpecification(criteria.getImpacto(), Incidente_.impacto));
            }
            if (criteria.getSolicitante() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSolicitante(), Incidente_.solicitante));
            }
            if (criteria.getCategoria() != null) {
                specification = specification.and(buildSpecification(criteria.getCategoria(), Incidente_.categoria));
            }
            if (criteria.getDataAbertura() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDataAbertura(), Incidente_.dataAbertura));
            }
            if (criteria.getUserId() != null) {
                specification = specification.and(buildSpecification(criteria.getUserId(),
                    root -> root.join(Incidente_.user, JoinType.LEFT).get(User_.id)));
            }
        }
        return specification;
    }
}
