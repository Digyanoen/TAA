package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.Request.ActivityRequest;
import fr.istic.taa.Server.Request.ActivityResponse;
import fr.istic.taa.Server.model.*;
import fr.istic.taa.Server.repository.ActivityDAO;
import fr.istic.taa.Server.repository.CityDAO;
import fr.istic.taa.Server.repository.UserDao;
import fr.istic.taa.Server.repository.WeatherConditionDAO;
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
@RequestMapping("/api/activity")
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
    public String create(@RequestBody ActivityRequest request){

        Activity activity = new Activity();


        City city = cityDAO.findOne(request.getCityId());
        User user = userDao.findOne(request.getUserId());

        WeatherCondition weatherCondition= new WeatherCondition();
        weatherCondition.setStrength(request.getStrength());
        weatherCondition.setName(WeatherEnum.valueOf(request.getCondition()));

        weatherConditionDAO.save(weatherCondition);

        activity.setWeatherCondition(weatherCondition);
        activity.setName(request.getName());
        activity.setCity(city);

        List<User> users = new ArrayList<User>();
        users.add(user);
        activity.setUsers(users);

        user.addActivity(activity);

//        city.getActivity().add(activity);


        try {
            activityDAO.save(activity);
            weatherConditionDAO.save(weatherCondition);
            cityDAO.save(city);
            userDao.save(user);
        }
        catch (Exception ex) {
            System.out.println("ici : " + ex.toString());
            return "Error creating the activity: " + ex.toString();
        }
        return "Activity succesfully created with id = " + activity.getId();
    }

    @RequestMapping("/list/{id}")
    @ResponseBody
    public List<ActivityResponse> find(@PathVariable("id") int id){

        List<ActivityResponse> activities  = new ArrayList<>();
        for(Activity a : userDao.findOne(id).getActivities()){
            WeatherCondition wc = a.getWeatherCondition();
            activities.add(new ActivityResponse(a.getId(),a.getName(),a.getCity().getName(),wc.getName(),wc.getStrength()));
        }
        return activities;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id){
        try {
            Activity activity = activityDAO.findOne(id);
            for(User u : activity.getUsers()){
                u.getActivities().remove(activity);
            }
            activityDAO.delete(activity);
        }
        catch (Exception ex) {
            return "Error deleting the activity:" + ex.toString();
        }
        return "Activity succesfully deleted!";
    }

//    @RequestMapping("/update")
//    @ResponseBody
//    public String update(@RequestBody Activity o){
//        try {
//            activityDAO.save(o);
//        }
//        catch (Exception ex) {
//            return "Error updating the activity: " + ex.toString();
//        }
//        return "Activity succesfully updated!";
//    }

//    @RequestMapping("/suscribe")
//    @ResponseBody
//    public String set(String ActivityId, String UserId){
//
//        int actId = Integer.parseInt(ActivityId);
//        int uId = Integer.parseInt(UserId);
//        Activity activity = activityDAO.findOne(actId);
//        User user = userDao.findOne(uId);
//        List list =user.getActivities();
//        if(list == null){
//            list = new ArrayList<Activity>();
//        }
//        list.add(activity);
//        userDao.save(user);
//        return "Activité ajouté";
//    }

}
