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
    private String level;

    /** List of users suscribed of this activity **/
    private List<User> users;


    public Activity() {}

    @Id
    @GeneratedValue
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
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
