package dao;

import java.util.List;


public interface Dao<T> {
    T  get(String id);
    List<T> getAll();
    void save(T t);
    void update(T newValues);
    void delete(T t);


}
