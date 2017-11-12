package fr.istic.taa.Server.controller;

import fr.istic.taa.Server.model.City;
import fr.istic.taa.Server.repository.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/city")
public class CityController {

    @Autowired
    private CityDAO cityDAO;

    @RequestMapping
    public List<City> get(){
        return cityDAO.findAll();
    }

}
