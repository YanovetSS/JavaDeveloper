package module03;

import module03.dao.CompaniesDAOImpl;
import module03.dao.CustomersDAOImpl;
import module03.dao.DevelopersDAOImpl;
import module03.model.Company;
import module03.model.Customers;
import module03.model.Developers;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 14.07.2017.
 */
public class Starter {
    public static void main(String[] args) {
        CompaniesDAOImpl compDAOImpl = new CompaniesDAOImpl();
        CustomersDAOImpl custDAOImpl = new CustomersDAOImpl();
//        Company addCompany = new Company("N1111155555");
//        Company updCompany = new Company();
        //true
        //compDAOImpl.addCompany(addCompany);
        //compDAOImpl.readCompany(5);
        //compDAOImpl.updateCompany("updExpCompany",5);
        //compDAOImpl.deleteCompany(6);/

        //get all company
//        List<Company> list = compDAOImpl.listCompany();
//
//        for (Company comp:
//            list ) {
//            System.out.println(comp);
//        }


//        Customers addCustomer = new Customers("secondCustomer");

        //true
        //custDAOImpl.addCustomers(addCustomer);
        //custDAOImpl.readCustomers(1);
        //custDAOImpl.updateCustomers("newName",2);
//        custDAOImpl.deleteCustomers(1);
//
//        List<Customers> custList = custDAOImpl.getAllCustomers();
//        for (Customers cust:
//             custList) {
//            System.out.println("customer: "+cust);
//        }

        DevelopersDAOImpl devDAOImpl = new DevelopersDAOImpl();
        Developers addDev = new Developers("Nazar","Yanovets",2000,1);
        devDAOImpl.addDevelopers(addDev);

    }
}
