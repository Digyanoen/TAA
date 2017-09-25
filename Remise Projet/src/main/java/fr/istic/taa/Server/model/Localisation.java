package fr.istic.taa.Server.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "localisation")
public class Localisation {

    /* the id */
    private int id;

    /* the latitude */
    private int lat;

    /* the longitude */
    private int lon;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    @NotNull
    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}
