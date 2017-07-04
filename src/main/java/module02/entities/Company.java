package module02.entities;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class Company {


    private int id;
    private String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public Company(){

    }
}
