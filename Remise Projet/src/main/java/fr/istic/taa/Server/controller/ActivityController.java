package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.model.*;
import fr.istic.taa.Server.repository.ActivityDAO;
import fr.istic.taa.Server.repository.CityDAO;
import fr.istic.taa.Server.repository.UserDao;
import fr.istic.taa.Server.repository.WeatherConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Activity controller for CRUD operations on an activity
 * @author NFortun
 */
@Controller
@RequestMapping("/activity")
public class ActivityController{

    @Resource
    private ActivityDAO activityDAO;

    @Resource
    private CityDAO cityDAO;

    @Resource
    private UserDao userDao;

    @Resource
    private WeatherConditionDAO weatherConditionDAO;



    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestBody Request request){

        Activity activity = request.getActivity();
        City city = cityDAO.findOne(request.getCity().getId());

        WeatherCondition weatherCondition= new WeatherCondition();
        weatherCondition.setStrength(request.getWeatherCondition().getStrength());
        weatherCondition.setCondition(request.getWeatherCondition().getCondition());
        activity.setWeatherCondition(weatherCondition);

        if(city == null) {
            city = new City();
            city.setCountry(request.getCity().getCountry());
            city.setName(request.getCity().getName());
        }
        city.getActivity().add(activity);

        try {
            cityDAO.save(city);
            weatherConditionDAO.save(weatherCondition);
            activityDAO.save(activity);
        }
        catch (Exception ex) {
            return "Error creating the activity: " + ex.toString();
        }
        return "Activity succesfully created with id = " + activity.getId();
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public Activity find(@PathVariable("id") int id){
        Activity activity = null;
        try {
            activity = activityDAO.findOne(id);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return activity;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id){
        try {
            activityDAO.delete(activityDAO.findOne(id));
        }
        catch (Exception ex) {
            return "Error deleting the activity:" + ex.toString();
        }
        return "Activity succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody Activity o){
        try {
            activityDAO.save(o);
        }
        catch (Exception ex) {
            return "Error updating the activity: " + ex.toString();
        }
        return "Activity succesfully updated!";
    }

    @RequestMapping("/suscribe")
    @ResponseBody
    public String set(String ActivityId, String UserId){

        int actId = Integer.parseInt(ActivityId);
        int uId = Integer.parseInt(UserId);
        Activity activity = activityDAO.findOne(actId);
        User user = userDao.findOne(uId);
        List list =user.getActivities();
        if(list == null){
            list = new ArrayList<Activity>();
        }
        list.add(activity);
        userDao.save(user);
        return "Activité ajouté";
    }

}
