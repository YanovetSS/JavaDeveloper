package module03.dao;


import module02.entities.Project;


import java.util.List;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface ProjectsDAO {
    void addProject(Project company);

    void readProject(int id);

    void updateProject(String name,int id);

    void deleteCompany(int id);

    List<module03.model.Project> listProject();
}
