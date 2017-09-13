package Server;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class User {


    private String login;

    private String password;

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
}
