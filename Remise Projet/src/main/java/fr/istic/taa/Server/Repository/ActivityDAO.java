package fr.istic.taa.Server.Repository;

import fr.istic.taa.Server.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * see inheritance doc
 * @author NFortun
 */
@Transactional
public interface ActivityDAO extends JpaRepository<Activity, Integer> {

}
