package module03.model;

import javax.persistence.*;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
@Entity
@Table(name = "CUSTOMERS")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "CUSTOMER_NAME")
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
