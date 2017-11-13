package fr.istic.taa.Server.Request;

import fr.istic.taa.Server.model.WeatherCondition;
import fr.istic.taa.Server.model.WeatherEnum;

public class ActivityResponse {
    private int id;

    private String name;

    private String city;

    private WeatherEnum condition_name;

    private int condition_strength;

    public ActivityResponse(int id, String name, String city, WeatherEnum condition_name, int condition_strength) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.condition_name = condition_name;
        this.condition_strength = condition_strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherEnum getCondition_name() {
        return condition_name;
    }

    public void setCondition_name(WeatherEnum condition_name) {
        this.condition_name = condition_name;
    }

    public int getCondition_strength() {
        return condition_strength;
    }

    public void setCondition_strength(int condition_strength) {
        this.condition_strength = condition_strength;
    }
}
