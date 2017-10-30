package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.meteo.MeteoHandler;
import fr.istic.taa.Server.model.Activity;
import fr.istic.taa.Server.model.WeatherCondition;
import fr.istic.taa.Server.repository.ActivityDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/meteo")
public class MeteoController {


    @Resource
    private ActivityDAO activityDAO;

    @RequestMapping("/check")
    public void check() throws InterruptedException {
        MeteoHandler meteoHandler = new MeteoHandler();
        List<Activity> activityList = activityDAO.findAll();
        for(Activity a : activityList) {
            WeatherCondition weatherCondition = a.getWeatherCondition();

            if(meteoHandler.isOk(weatherCondition)){
                meteoHandler.sendForecast(a.getUsers(), "You can do "+a.getName());
            }
            else{
                meteoHandler.sendForecast(a.getUsers(), "Stay at home");
            }
        }

    }





}
