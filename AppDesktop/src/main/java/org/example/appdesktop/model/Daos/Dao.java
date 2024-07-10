package org.example.appdesktop.model.Daos;

import java.util.List;

public interface Dao<T> {
    public T get(long id);
    public void insert(T object);
    public void delete(T object);
    public void deleteAll();
    public void update(T object);
    public boolean deleteById(long id);
    public List<Integer> getAllIds();
    public List<T> getAll();

}
