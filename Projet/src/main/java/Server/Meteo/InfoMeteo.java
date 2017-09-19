package Server.Meteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoMeteo {
    public int dt;
    public Donnees main;
    public List<Meteo> weather;
    public Nuage clouds;
    public Vent wind;

    @Override
    public String toString() {
        return String.valueOf(dt);
    }
}
