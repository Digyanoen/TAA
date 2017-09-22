package fr.istic.taa.Server.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meteo {
    private int id;
    private String main;
    private String description;
}
