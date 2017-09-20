package Server.Repository;

import Server.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * see inheritance doc
 * @author NFortun
 */
public interface ActivityDAO extends JpaRepository<Activity, Integer> {

}
