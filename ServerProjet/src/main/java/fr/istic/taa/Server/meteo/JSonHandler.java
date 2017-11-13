package fr.istic.taa.Server.meteo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import fr.istic.taa.Server.model.City;
import fr.istic.taa.Server.repository.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;


@Controller
public class JSonHandler {

    private static final String APPID = "bfdd02437030a6c26f0802d118987170";

    @Autowired
    private CityDAO cityDAO;


    public MeteoHandler getMeteoPinPoint(int lat, int lon) {
        MeteoHandler met = new MeteoHandler();
        try {
            ObjectMapper mapper = new ObjectMapper();
            met = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/forecast?lat=" + String.valueOf(lat) + "&lon=" + String.valueOf(lon) + "&appid=" + APPID), MeteoHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return met;
    }

    @PostConstruct
    public void buildCityID() {
        ObjectMapper map = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            List<City> cities = map.readValue(new File("city.smalllist.json"), TypeFactory.defaultInstance().constructCollectionType(List.class, City.class));
                cityDAO.save(cities);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public MeteoHandler getMeteoPinPoint(City city) {
        MeteoHandler met = new MeteoHandler();
        try {
            ObjectMapper mapper = new ObjectMapper();
            met = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + city.getName() + "," + city.getCountry() + "&appid=" + APPID), MeteoHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return met;
    }
}
