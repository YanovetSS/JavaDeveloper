package module02.entities;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class Project {
    private int id;
    private String projectName;
    private int cost;
    private int companyId;
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
