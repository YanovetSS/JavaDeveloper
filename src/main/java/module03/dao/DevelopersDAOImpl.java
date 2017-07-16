package module03.dao;

import module03.Utils.HibernateUtil;
import module03.model.Customers;
import module03.model.Developers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 16.07.2017.
 */
public class DevelopersDAOImpl implements DevelopersDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompaniesDAOImpl.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addDevelopers(Developers developers) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(developers);
            logger.info("Save developers succesfully");
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
                logger.info("session close!");
            }
        }
    }

    @Override
    public void readDevelopers(int id) {
        Session session= null;
        try{
            session=sessionFactory.openSession();
            session.beginTransaction();
            Developers developers = session.get(Developers.class,id);
            System.out.println("Customer: "+developers.toString());
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
    public void updateDevelopers(String name, int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();

            Developers updDeveloper = (Developers) session.get(Developers.class,id);
            updDeveloper.setName(name);
            session.update(updDeveloper);
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
    public void deleteDevelopers(int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Developers developers=  session.get(Developers.class,id);
            session.delete(developers);
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
    public List<Developers> listDevelopers() {
        Session session = null;
        try{
            session=sessionFactory.openSession();
            session.beginTransaction();
            List<Developers> listCustomers = session.createQuery("from Developers order by ID").list();
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
