package Server.Repository;

import Server.Model.User;
import Server.jpa.EntityManagerHelper;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Query;

/**
 * see inheritance doc
 * @author NFortun
 */
public interface UserDAO extends JpaRepository<User, Integer>{


}
