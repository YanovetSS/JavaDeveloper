package module03.dao;


import module03.model.Skills;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface SkillsDAO {
    void addSkill(Skills skills);

    void readSkill(int id);

    void updateSkill(String name,int id);

    void deleteSkill(int id);

    List<Skills> listCompany();
}
