package fr.istic.taa.Server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Weather POJO
 */
@Entity
public class WeatherCondition {

    private int strength;

    private WeatherEnum condition;

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
    public WeatherEnum getCondition() {
        return condition;
    }

    public void setCondition(WeatherEnum condition) {
        this.condition = condition;
    }
}
