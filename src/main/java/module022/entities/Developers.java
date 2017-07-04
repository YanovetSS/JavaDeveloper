package module022.entities;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class Developers {
    private int id ;
    private String name;
    private String surName;
    private int salary;
    private int projectsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    @Override
    public String
    toString() {
        return "Developers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", projectsId=" + projectsId +
                '}';
    }

    public Developers(String name, String surName, int salary, int projectsId) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.projectsId = projectsId;
    }

    public Developers(){

    }

}
