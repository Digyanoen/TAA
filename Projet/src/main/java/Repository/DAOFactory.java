package Repository;

/**
 * @author NFortun
 * Factory which provides DAOs
 */
public class DAOFactory {

    private UserDAO userDAO;
    private ActivityDAO activityDAO;
    private WeatherConditionDAO weatherConditionDAO;

    /**
     * Create an UserDAO if userDAO is null
     * @return userDAO
     */
    public UserDAO getUserDAO() {
        if(userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
    }

    /**
     * Create an ActivityDAO if activityDAO is null
     * @return ActivityDAO
     */
    public ActivityDAO getActivityDAO() {
        if(activityDAO == null)
            activityDAO = new ActivityDAO();
        return activityDAO;
    }

    /**
     * Create a WeatherConditionDAO if weatherConditionDAO is null
     * @return weatherConditionDAO
     */
    public WeatherConditionDAO getWeatherConditionDAO() {
        if(weatherConditionDAO == null)
            weatherConditionDAO = new WeatherConditionDAO();
        return weatherConditionDAO;
    }
}
