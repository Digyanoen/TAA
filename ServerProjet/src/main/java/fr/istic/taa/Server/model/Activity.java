package fr.istic.taa.Server.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Activity POJO
 */
@Entity
@Table(name = "activity")
public class Activity {

    /** the id **/
    private int id;

    /** the name **/
    private String name;

    /** the level **/
    private int level;

    private City city;

    private WeatherCondition weatherCondition;

    /** List of users suscribed of this activity **/
    private List<User> users;


    public Activity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToOne
    @JoinTable( name = "ACTIVITY_CITY"  ,
            joinColumns = @JoinColumn(name ="ACTIVITY_ID"),
            inverseJoinColumns = @JoinColumn(name ="CITY_ID"))
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @OneToOne
    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}


