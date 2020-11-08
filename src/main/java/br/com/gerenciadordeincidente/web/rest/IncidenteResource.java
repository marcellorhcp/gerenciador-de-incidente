package br.com.gerenciadordeincidente.web.rest;

import br.com.gerenciadordeincidente.domain.Incidente;
import br.com.gerenciadordeincidente.service.IncidenteService;
import br.com.gerenciadordeincidente.web.rest.errors.BadRequestAlertException;
import br.com.gerenciadordeincidente.service.dto.IncidenteCriteria;
import br.com.gerenciadordeincidente.service.IncidenteQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link br.com.gerenciadordeincidente.domain.Incidente}.
 */
@RestController
@RequestMapping("/api")
public class IncidenteResource {

    private final Logger log = LoggerFactory.getLogger(IncidenteResource.class);

    private static final String ENTITY_NAME = "incidente";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IncidenteService incidenteService;

    private final IncidenteQueryService incidenteQueryService;

    public IncidenteResource(IncidenteService incidenteService, IncidenteQueryService incidenteQueryService) {
        this.incidenteService = incidenteService;
        this.incidenteQueryService = incidenteQueryService;
    }

    /**
     * {@code POST  /incidentes} : Create a new incidente.
     *
     * @param incidente the incidente to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new incidente, or with status {@code 400 (Bad Request)} if the incidente has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/incidentes")
    public ResponseEntity<Incidente> createIncidente(@RequestBody Incidente incidente) throws URISyntaxException {
        log.debug("REST request to save Incidente : {}", incidente);
        if (incidente.getId() != null) {
            throw new BadRequestAlertException("A new incidente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Incidente result = incidenteService.save(incidente);
        return ResponseEntity.created(new URI("/api/incidentes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /incidentes} : Updates an existing incidente.
     *
     * @param incidente the incidente to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated incidente,
     * or with status {@code 400 (Bad Request)} if the incidente is not valid,
     * or with status {@code 500 (Internal Server Error)} if the incidente couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/incidentes")
    public ResponseEntity<Incidente> updateIncidente(@RequestBody Incidente incidente) throws URISyntaxException {
        log.debug("REST request to update Incidente : {}", incidente);
        if (incidente.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Incidente result = incidenteService.save(incidente);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, incidente.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /incidentes} : get all the incidentes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of incidentes in body.
     */
    @GetMapping("/incidentes")
    public ResponseEntity<List<Incidente>> getAllIncidentes(IncidenteCriteria criteria) {
        log.debug("REST request to get Incidentes by criteria: {}", criteria);
        List<Incidente> entityList = incidenteQueryService.findByCriteria(criteria);
        entityList.sort(Comparator.comparingInt(Incidente::getPrioridade)
        						  .reversed()
        						  .thenComparing(Comparator.comparing(Incidente::getDataAbertura,Comparator.reverseOrder()))
        						  .reversed()
        						  .thenComparing(i->i.getStatus().getOrdem()));
        return ResponseEntity.ok().body(entityList);
    }

    /**
     * {@code GET  /incidentes/count} : count all the incidentes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/incidentes/count")
    public ResponseEntity<Long> countIncidentes(IncidenteCriteria criteria) {
        log.debug("REST request to count Incidentes by criteria: {}", criteria);
        return ResponseEntity.ok().body(incidenteQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /incidentes/:id} : get the "id" incidente.
     *
     * @param id the id of the incidente to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the incidente, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/incidentes/{id}")
    public ResponseEntity<Incidente> getIncidente(@PathVariable Long id) {
        log.debug("REST request to get Incidente : {}", id);
        Optional<Incidente> incidente = incidenteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(incidente);
    }

    /**
     * {@code DELETE  /incidentes/:id} : delete the "id" incidente.
     *
     * @param id the id of the incidente to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/incidentes/{id}")
    public ResponseEntity<Void> deleteIncidente(@PathVariable Long id) {
        log.debug("REST request to delete Incidente : {}", id);
        incidenteService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
