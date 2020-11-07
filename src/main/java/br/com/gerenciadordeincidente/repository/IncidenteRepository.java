package br.com.gerenciadordeincidente.repository;

import br.com.gerenciadordeincidente.domain.Incidente;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Incidente entity.
 */
@SuppressWarnings("unused")
@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long>, JpaSpecificationExecutor<Incidente> {

    @Query("select incidente from Incidente incidente where incidente.user.login = ?#{principal.username}")
    List<Incidente> findByUserIsCurrentUser();
}
