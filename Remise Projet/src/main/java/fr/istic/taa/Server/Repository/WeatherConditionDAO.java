package fr.istic.taa.Server.Repository;

import fr.istic.taa.Server.Model.WeatherCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * see inheritance doc
 * @author NFortun
 */
@Transactional
public interface WeatherConditionDAO extends JpaRepository<WeatherCondition, Integer> {

}
