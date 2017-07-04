package Offlane3.DAOs;

import java.io.Serializable;

/**
 * Created by MakeMeSm1Le- on 12.06.2017.
 */
public interface GeneralDAO <K extends Serializable,T> {
    void create(T entity);
    T read(K key);
    void update(T entity);
    void delete (T entity);
}
