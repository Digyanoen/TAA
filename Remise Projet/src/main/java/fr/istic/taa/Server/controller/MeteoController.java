package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.meteo.JSonHandler;
import fr.istic.taa.Server.meteo.MeteoHandler;
import fr.istic.taa.Server.model.Activity;
import fr.istic.taa.Server.model.City;
import fr.istic.taa.Server.model.WeatherCondition;
import fr.istic.taa.Server.repository.ActivityDAO;
import fr.istic.taa.Server.repository.CityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/meteo")
public class MeteoController {


    @Resource
    private ActivityDAO activityDAO;

    @Resource
    private CityDAO cityDAO;

    @RequestMapping("/check")
    public void check() throws InterruptedException {
        JSonHandler jSonHandler = new JSonHandler();
        MeteoHandler meteoHandler;
        WeatherCondition weatherCondition;
        List <City> cities = cityDAO.findAll();
        for(City c : cities){
            meteoHandler = jSonHandler.getMeteoPinPoint(c);
            List<Activity> activities = activityDAO.findActivitiesByCity_Name(c.getName());
            for(Activity activity : activities){
                weatherCondition = activity.getWeatherCondition();
                if(meteoHandler.isOk(weatherCondition)){
                    meteoHandler.sendForecast(activity.getUsers(), "You can do "+activity.getName());
                }
                else{
                    meteoHandler.sendForecast(activity.getUsers(), "Stay at home");
                }

            }
        }


    }





}
