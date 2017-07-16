package module03.dao;


import module03.model.Developers;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface DevelopersDAO {
    void addDevelopers(Developers developers);

    void readDevelopers(int id);

    void updateDevelopers(String name,int id);

    void deleteDevelopers(int id);

    List<Developers> listDevelopers();
}
