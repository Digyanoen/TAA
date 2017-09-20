package Server.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author NFortun
 * Factory which provides DAOs
 */
@Component
public class DaoFactory {

    private UserDAO userDAO;

    private ActivityDAO activityDAO;

    private WeatherConditionDAO weatherConditionDAO;


    /**
     * Create an UserDAO if userDAO is null
     * @return userDAO
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * Create an ActivityDAO if activityDAO is null
     * @return ActivityDAO
     */
    public ActivityDAO getActivityDAO() {
        return activityDAO;
    }

    /**
     * Create a WeatherConditionDAO if weatherConditionDAO is null
     * @return weatherConditionDAO
     */
    public WeatherConditionDAO getWeatherConditionDAO() {
        return weatherConditionDAO;
    }
}
