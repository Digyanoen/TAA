package Repository;

public abstract class DAO<T> {

    public abstract T find(int id);
    public abstract void create(T o);
    public abstract void delete(T o);
    public abstract void update(T o);

}
