package Repository;

import Server.WeatherCondition;
import jpa.EntityManagerHelper;

import javax.persistence.Query;

/**
 * see inheritance doc
 * @author NFortun
 */
public class WeatherConditionDAO extends DAO<WeatherCondition>{


    public WeatherCondition find(int id) {
        Query query= EntityManagerHelper.createQuery("SELECT * FROM WEATHERCONDITION WHERE id = :id");
        query.setParameter("id", id);
        return (WeatherCondition) query.getSingleResult();
    }



    public void delete(WeatherCondition o) {

    }

    public void update(WeatherCondition o) {
        EntityManagerHelper.beginTransaction();
        Query query= EntityManagerHelper.createQuery(
                "UPDATE WEATHERCONDITION SET  strength = :strength WHERE id = :id");
        query.setParameter("id", o.getId());
        query.setParameter("strength", o.getStrength());
        query.executeUpdate();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
