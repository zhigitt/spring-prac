package java12.repo;

import java.util.List;

public interface GenericRepo<T, ID> {
    T save(T object);

    T findById(ID id);

    List<T> getAll();

    T updateById(ID id, T newObject);

    void deleteById(ID id);
}
