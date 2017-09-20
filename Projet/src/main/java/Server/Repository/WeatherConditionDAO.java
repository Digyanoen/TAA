package Server.Repository;

import Server.Model.WeatherCondition;
import Server.jpa.EntityManagerHelper;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Query;

/**
 * see inheritance doc
 * @author NFortun
 */
public interface WeatherConditionDAO extends JpaRepository<WeatherCondition, Integer>{

}
