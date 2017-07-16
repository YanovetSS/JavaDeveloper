package module03.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
@Entity
@Table(name = "DEVELOPERS")
public class Developers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id ;

    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surName;
    @Column(name = "SALARY")
    private int salary;

    @Column(name = "PROJECT_ID")
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
