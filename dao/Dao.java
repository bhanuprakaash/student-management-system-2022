package dao;

import java.util.Comparator;
import java.util.List;


public interface Dao<T> {
    T  get(String id);
    List<T> getAll();
    void add(T t);
    void update(T newValues);
    void delete(String studentId);
    List<T> sortStudents(Comparator<T> by);

}
