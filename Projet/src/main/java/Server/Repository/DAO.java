package Server.Repository;

import Server.jpa.EntityManagerHelper;

/**
 * CRUD methods for DAO class
 * @param <T>
 */
public abstract class DAO<T> {
    /**
     * Find an object o in a database
     * @param id the id of the object
     * @return the object
     */
    public abstract T find(int id);

    /**
     * Delete the object o of his table
     * @param o the object to delete
     */
    public abstract void delete(T o);

    /**
     * Update the object o
     * @param o the object to update
     */
    public abstract void update(T o);

    /**
     * Create an object o in database
     * @param o the object to create
     */
    public  void create(T o){

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(o);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

}
