package Server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Weather POJO
 */
@Entity
public class WeatherCondition {

    int strength;

    int id;

    public WeatherCondition() {
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strenght) {
        this.strength = strenght;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
