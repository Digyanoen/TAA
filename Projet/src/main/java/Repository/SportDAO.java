package Repository;

import Server.User;

import java.util.List;

public interface SportDAO {
    // SELECT * FROM user_sport JOIN sport where user.id = :id
    public User findAllSportForUser();

    // SELECT login from user_sport_ JOIN sport where level = :level
    public List<User> findAllUserByLevel();
}
