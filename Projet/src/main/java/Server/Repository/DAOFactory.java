package Server.Repository;

/**
 * @author NFortun
 * Factory which provides DAOs
 */
public class DAOFactory {

    private static UserDAO userDAO;
    private static  ActivityDAO activityDAO;
    private static  WeatherConditionDAO weatherConditionDAO;


    /**
     * Create an UserDAO if userDAO is null
     * @return userDAO
     */
    public static UserDAO getUserDAO() {
        if(userDAO == null)
            userDAO = new UserDAO();
        return userDAO;
    }

    /**
     * Create an ActivityDAO if activityDAO is null
     * @return ActivityDAO
     */
    public static ActivityDAO getActivityDAO() {
        if(activityDAO == null)
            activityDAO = new ActivityDAO();
        return activityDAO;
    }

    /**
     * Create a WeatherConditionDAO if weatherConditionDAO is null
     * @return weatherConditionDAO
     */
    public static WeatherConditionDAO getWeatherConditionDAO() {
        if(weatherConditionDAO == null)
            weatherConditionDAO = new WeatherConditionDAO();
        return weatherConditionDAO;
    }
}
