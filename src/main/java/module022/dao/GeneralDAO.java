package module022.dao;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface GeneralDAO <K extends Serializable, T> {
    Optional<T> read(K key);

    void create(T entity);

    void update(T entity,K key);

    void delete(T entity);
}

