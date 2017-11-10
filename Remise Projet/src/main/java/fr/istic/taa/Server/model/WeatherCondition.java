package fr.istic.taa.Server.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Weather POJO
 */
@Entity
public class WeatherCondition {

    private int strength;

    private WeatherEnum name;

    private int id;

    public WeatherCondition() {
    }

    @NotNull
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strenght) {
        this.strength = strenght;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Enumerated
    public WeatherEnum getName() {
        return name;
    }

    public void setName(WeatherEnum condition) {
        this.name = condition;
    }
}
