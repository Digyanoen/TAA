package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.model.WeatherCondition;
import fr.istic.taa.Server.repository.WeatherConditionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Weather Controller for CRUD operations on a weather conditions
 * @author NFortun
 */
@Controller
@RequestMapping("/weather-condition")
public class WeatherConditionController{

    @Autowired
    private WeatherConditionDAO weatherConditionDAO;

    @RequestMapping("/create")
    @ResponseBody
    public String create(@RequestBody int strength){
        String weatherId;
        try {
            WeatherCondition weather= new WeatherCondition();
            weather.setStrength(strength);
            weatherConditionDAO.save(weather);
            weatherId = String.valueOf(weather.getId());
        }
        catch (Exception ex) {
            return "Error creating the weather: " + ex.toString();
        }
        return "Weather succesfully created with id = " + weatherId;
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public String find(@PathVariable("id")  int id){
        String weatherId;
        try {
            WeatherCondition activity = weatherConditionDAO.findOne(id);
            weatherId = String.valueOf(activity.getId());
        }
        catch (Exception ex) {
            return "Weather not found";
        }
        return "The weather id is: " + weatherId;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable("id") int id){
        try {
            weatherConditionDAO.delete(weatherConditionDAO.findOne(id));
        }
        catch (Exception ex) {
            return "Error deleting the weather:" + ex.toString();
        }
        return "Weather succesfully deleted!";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody WeatherCondition o){
        try {
            weatherConditionDAO.save(o);
        }
        catch (Exception ex) {
            return "Error updating the weather: " + ex.toString();
        }
        return "Weather succesfully updated!";
    }

}
