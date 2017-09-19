package Server.Model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
@Entity
public class User {

    private int id;

    private String login;

    private String password;

    private List<Activity> activities;

    @Id
    @GeneratedValue
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
