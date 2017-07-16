package module03.dao;

import module03.Utils.HibernateUtil;
import module03.model.Customers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by MakeMeSm1Le- on 16.07.2017.
 */
public class CustomersDAOImpl  implements CustomersDAO{
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private  static final Logger logger = LoggerFactory.getLogger(CustomersDAOImpl.class);
    @Override
    public void addCustomers(Customers customers) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(customers);
            session.getTransaction().commit();
            logger.info("saved succesfully");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
                logger.info("session closed!");
            }
        }
    }

    @Override
    public void readCustomers(int id) {
        Session session= null;
        try{
            session=sessionFactory.openSession();
            session.beginTransaction();
            Customers customers = (Customers)session.get(Customers.class,id);
            System.out.println("Customer: "+customers.toString());
            session.getTransaction().commit();
            logger.info("read succesfully");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }finally {
            if(session!= null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateCustomers(String name, int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();

            Customers updCustomer = (Customers)session.get(Customers.class,id);
            updCustomer.setCustumerName(name);
            session.update(updCustomer);
            session.getTransaction().commit();
            logger.info("update succesfully");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
                logger.info("session close!");
            }
        }
    }

    @Override
    public void deleteCustomers(int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Customers customers =  session.get(Customers.class,id);
            session.delete(customers);
            session.getTransaction().commit();
            logger.info("delete succesfully");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
                logger.info("session close!");
            }
        }
    }

    @Override
    public List<Customers> getAllCustomers() {
        Session session = null;
        try{
            session=sessionFactory.openSession();
            session.beginTransaction();
            List<Customers> listCustomers = session.createQuery("from Customers order by ID").list();
            session.getTransaction().commit();
            return listCustomers;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
}
