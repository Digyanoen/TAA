package fr.istic.taa.Server.Model;
// Imports ...

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    private int id;

    private String login;

    private String password;

    private String email;

    private List<Activity> activities;

    public User (String email, String login, String password){
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @ManyToMany
    @JoinTable(
            name="USER_ACTIVITY",
            joinColumns=@JoinColumn(name="USERS_LOGIN"),
            inverseJoinColumns= @JoinColumn(name="ACTIVITIES_ID")
    )
    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addSport(Activity activity) { activities.add(activity); }
}