package Server.Model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
public class User {

    private String login;

    private String password;

    private List<Activity> activities;

    @Id
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
