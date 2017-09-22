package fr.istic.taa.Server.Model;

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

    int strength;

    int id;

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
    @GeneratedValue(strategy= GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
