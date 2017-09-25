package fr.istic.taa.Server.meteo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

public class JSonHandler {

    private static final String APPID = "bfdd02437030a6c26f0802d118987170";

    public static MeteoHandler getMeteoPinPoint(int lat, int lon){
        MeteoHandler met = new MeteoHandler();
        try {
            ObjectMapper mapper = new ObjectMapper();
            met = mapper.readValue(new URL("http://samples.openweathermap.org/data/2.5/forecast?lat="+ String.valueOf(lat) +"&lon="+ String.valueOf(lon) +"&appid="+APPID), MeteoHandler.class);
            } catch (Exception e) {
            e.printStackTrace();
        }
        return met;
    }
}
