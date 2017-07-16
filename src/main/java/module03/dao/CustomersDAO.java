package module03.dao;


import module03.model.Customers;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public interface CustomersDAO  {
    void addCustomers(Customers customers);
    void readCustomers(int id);

    void updateCustomers(String name, int id);
    void deleteCustomers(int id);

    List<Customers> getAllCustomers();
}
