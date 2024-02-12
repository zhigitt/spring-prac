package java12.service;

import java.util.List;

public interface GenericService <T, ID>{
    T save(T object);

    T findById(ID id);

    List<T> getAll();

    T updateById(ID id, T newObject);

    void deleteById(ID id);
}
