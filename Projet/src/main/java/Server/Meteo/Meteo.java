package Server.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meteo {
    public int id;
    public String main;
    public String description;
}
