package fr.istic.taa.Server.Controller;

import fr.istic.taa.Server.Model.WeatherCondition;
import fr.istic.taa.Server.Repository.WeatherConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * see inheritance doc
 * @author NFortun
 */
@Controller
public class WeatherConditionController{

    @RequestMapping("/create")
    @ResponseBody
    public String create(int strength){
        String weatherId;
        try {
            WeatherCondition weather= new WeatherCondition();
            weather.setStrength(strength);
            WeatherConditionDAO.save(weather);
            weatherId = String.valueOf(weather.getId());
        }
        catch (Exception ex) {
            return "Error creating the weather: " + ex.toString();
        }
        return "Weather succesfully created with id = " + weatherId;
    }

    @RequestMapping("/find")
    @ResponseBody
    public String find(int id){
        String weatherId;
        try {
            WeatherCondition activity = WeatherConditionDAO.findOne(id);
            weatherId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "Weather not found";
        }
        return "The weather id is: " + weatherId;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(WeatherCondition o){
        try {
            WeatherConditionDAO.delete(o);
        }
        catch (Exception ex) {
            return "Error deleting the weather:" + ex.toString();
        }
        return "Weather succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(WeatherCondition o){
        try {
        }
        catch (Exception ex) {
            return "Error updating the weather: " + ex.toString();
        }
        return "Weather succesfully updated!";
    }

    @Autowired
    private WeatherConditionDAO WeatherConditionDAO;

    /*public WeatherCondition find(int id) {
        Query query= EntityManagerHelper.createQuery("SELECT weather FROM WEATHERCONDITION as weather WHERE id = :id");
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
    }*/
}
