package Repository;

import jpa.EntityManagerHelper;

/**
 * CRUD methods for DAO class
 * @param <T>
 */
public abstract class DAO<T> {

    public abstract T find(int id);

    public abstract void delete(T o);
    public abstract void update(T o);
    public  void create(T o){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(o);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

}
