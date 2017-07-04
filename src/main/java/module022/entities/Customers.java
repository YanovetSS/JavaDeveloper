package module022.entities;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class Customers {
    private int id;
    private String custumerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustumerName() {
        return custumerName;
    }

    public void setCustumerName(String custumerName) {
        this.custumerName = custumerName;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", custumerName='" + custumerName + '\'' +
                '}';
    }

    public Customers(String custumerName) {
        this.custumerName = custumerName;
    }

    public Customers(){

    }
}
