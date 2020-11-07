package br.com.gerenciadordeincidente.service;

import br.com.gerenciadordeincidente.domain.Incidente;
import br.com.gerenciadordeincidente.repository.IncidenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Incidente}.
 */
@Service
@Transactional
public class IncidenteService {

    private final Logger log = LoggerFactory.getLogger(IncidenteService.class);

    private final IncidenteRepository incidenteRepository;

    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    /**
     * Save a incidente.
     *
     * @param incidente the entity to save.
     * @return the persisted entity.
     */
    public Incidente save(Incidente incidente) {
        log.debug("Request to save Incidente : {}", incidente);
        return incidenteRepository.save(incidente);
    }

    /**
     * Get all the incidentes.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Incidente> findAll() {
        log.debug("Request to get all Incidentes");
        return incidenteRepository.findAll();
    }


    /**
     * Get one incidente by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Incidente> findOne(Long id) {
        log.debug("Request to get Incidente : {}", id);
        return incidenteRepository.findById(id);
    }

    /**
     * Delete the incidente by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Incidente : {}", id);
        incidenteRepository.deleteById(id);
    }
}
