package Server.Repository;

import Server.Model.User;
import Server.jpa.EntityManagerHelper;

import javax.persistence.Query;

/**
 * see inheritance doc
 * @author NFortun
 */
public class UserDAO extends DAO<User>{

    public User find(int id) {

        Query query= EntityManagerHelper.createQuery("SELECT * FROM User WHERE id = :id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    public void delete(User o){
    }

    public void update(User o) {
        EntityManagerHelper.beginTransaction();
        Query query= EntityManagerHelper.createQuery(
                "UPDATE User SET  password = :password WHERE login = :login");
        query.setParameter("login", o.getLogin());
        query.setParameter("password", o.getPassword());
        query.executeUpdate();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
