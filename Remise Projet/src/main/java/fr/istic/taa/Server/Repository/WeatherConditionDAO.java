package fr.istic.taa.Server.Repository;

import fr.istic.taa.Server.Model.WeatherCondition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * see inheritance doc
 * @author NFortun
 */
public interface WeatherConditionDAO extends JpaRepository<WeatherCondition, Integer> {

}
