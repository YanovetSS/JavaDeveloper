package module022;

import module022.daoImpl.*;
import module022.entities.*;

/**
 * Created by MakeMeSm1Le- on 01.07.2017.
 */
public class App {
    public static void main(String[] args) {
        DevelopersDAOImpl developersDAO = new DevelopersDAOImpl();
        Developers developersForCreate = new Developers("GREEN", "GEGE", 2000, 1);
        Developers developersForUpdate = new Developers("LALALA", "1111", 3000, 2);
        Developers developersForDelete = new Developers("Victor", "lalla", 200, 1);
        //true
        developersDAO.read("Nazar");

        //true
        //developersDAO.create(developersForCreate);

        //true
        //developersDAO.update(developersForUpdate,"Vlad");

        //true, foren key ne daet ydalit!
        //developersDAO.delete(developersForDelete);


        CompaniesDAOImpl companiesDAO = new CompaniesDAOImpl();
        Company companyForCreateAndDelete = new Company("NazYanCompany");
        Company companyForUpdateEnterName = new Company("NewCompany");

        //true
        //companiesDAO.read("Google");

        //true
        //companiesDAO.create(companyForCreate);

        //true
        //companiesDAO.update(companyForUpdateEnterName,"Google");

        //true
        //companiesDAO.delete(companyForCreateAndDelete);


        CustomersDAOImpl customersDAO = new CustomersDAOImpl();

        //true
        //customersDAO.read("Yellow");

        Customers customersForCreate = new Customers("NewCustomers");
        //true
        //customersDAO.create(customersForCreate);

        Customers customersForUpdate = new Customers("UPDATE");
        //true
        //customersDAO.update(customersForUpdate,"Yellow");

        Customers customersForDelete = new Customers("NewCustomers");
        //true
        //customersDAO.delete(customersForDelete);

        ProjectDAOImpl projectDAO = new ProjectDAOImpl();

        //true
        //projectDAO.read("PN_ONE");

        Project projectForCreate = new Project("CreatePROJECt",1000,1,1);
        //true
        //projectDAO.create(projectForCreate);

        Project projectForUpdate = new Project("UpdateProject",1000,2,3);

        //true
        //projectDAO.update(projectForUpdate,"PM_Three");

        //true
       // projectDAO.delete(projectForUpdate);

        SkillsDAOImpl skillsDAO = new SkillsDAOImpl();
        //true
        //skillsDAO.read("Java");

        Skills skillsForCreate = new Skills("GO");
        //true
        //skillsDAO.create(skillsForCreate);


        //true
        //skillsDAO.delete(skillsForCreate);
    }
}
