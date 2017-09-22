package fr.istic.taa.Server.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoMeteo {
    private int dt;
    private Donnees main;
    private List<Meteo> weather;
    private Nuage clouds;
    private Vent wind;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Donnees getMain() {
        return main;
    }

    public void setMain(Donnees main) {
        this.main = main;
    }

    public List<Meteo> getWeather() {
        return weather;
    }

    public void setWeather(List<Meteo> weather) {
        this.weather = weather;
    }

    public Nuage getClouds() {
        return clouds;
    }

    public void setClouds(Nuage clouds) {
        this.clouds = clouds;
    }

    public Vent getWind() {
        return wind;
    }

    public void setWind(Vent wind) {
        this.wind = wind;
    }


}
