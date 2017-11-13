package fr.istic.taa.Server.repository;

import fr.istic.taa.Server.model.Activity;
import fr.istic.taa.Server.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * see inheritance doc
 * @author NFortun
 */
@Transactional
public interface ActivityDAO extends JpaRepository<Activity, Integer> {

    public List<Activity> findActivitiesByCity_Name(String name);


}
