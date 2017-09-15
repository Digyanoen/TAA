package Repository;

import Server.User;

public interface UserDAO {

    // SELECT * from user where id = :id
    public User findById();
}
