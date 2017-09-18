package Repository;

import Server.Activity;
import jpa.EntityManagerHelper;

import javax.persistence.Query;


public class ActivityDAO extends DAO<Activity>{

    public Activity find(int id) {
        Query query= EntityManagerHelper.createQuery("SELECT * FROM Activity WHERE id = :id");
        query.setParameter("id", id);
        return (Activity) query.getSingleResult();
    }

    public void create(Activity o) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(o);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    public void delete(Activity o) {
    }

    public void update(Activity o) {
        EntityManagerHelper.beginTransaction();
        Query query= EntityManagerHelper.createQuery(
                "UPDATE Activity SET  name = :name, level = :level WHERE id = :id");
        query.setParameter("id", o.getId());
        query.setParameter("name", o.getName());
        query.setParameter("level", o.getLevel());
        int i =query.executeUpdate();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}