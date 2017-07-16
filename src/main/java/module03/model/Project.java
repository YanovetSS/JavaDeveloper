package module03.model;

import javax.persistence.*;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */

@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    @Column(name = "COST")
    private int cost;
    @Column(name = "COMPANY_ID")
    private int companyId;
    @Column(name = "CUSTOMERS_ID")
    private int custumersId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCustumersId() {
        return custumersId;
    }

    public void setCustumersId(int custumersId) {
        this.custumersId = custumersId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", cost=" + cost +
                ", companyId=" + companyId +
                ", custumersId=" + custumersId +
                '}';
    }

    public Project(String projectName, int cost, int companyId, int custumersId) {
        this.projectName = projectName;
        this.cost = cost;
        this.companyId = companyId;
        this.custumersId = custumersId;
    }

    public Project (){

    }
}
