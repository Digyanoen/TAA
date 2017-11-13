package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.model.City;
import fr.istic.taa.Server.repository.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityDAO cityDAO;

    @RequestMapping
    @ResponseBody
    public List<City> get(){
        System.out.println("ok");
        return cityDAO.findAll();
    }

}
