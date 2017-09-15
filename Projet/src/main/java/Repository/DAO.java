package Repository;

public abstract class DAO<T> {

    public abstract T find(int id);
    public abstract boolean create(T o);
    public abstract boolean delete(T o);
    public abstract boolean update(T o);

}
