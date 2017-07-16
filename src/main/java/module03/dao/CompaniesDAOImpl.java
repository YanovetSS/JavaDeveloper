package module03.dao;

import module03.Utils.HibernateUtil;

import module03.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


/**
 * Created by MakeMeSm1Le- on 14.07.2017.
 */
public class CompaniesDAOImpl implements CompaniesDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompaniesDAOImpl.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addCompany(Company company) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(company);
            logger.info("Save company succesfully");
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
    public void readCompany(int id) {
        Session session= null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Company company = (Company)session.get(Company.class,id);
            logger.info("Readed succesfully: " +company);
            session.beginTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }

    @Override
    public void updateCompany(String name, int id) {
        Session session =  null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Company updCompany  = (Company)session.get(Company.class,id);
            updCompany.setCompanyName(name);
            session.update(updCompany);
            session.getTransaction().commit();
            logger.info("update succesfully");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }finally {
            if(session!=null  && session.isOpen()){
                session.close();
                logger.info("session closed!");
            }
        }
    }

    @Override
    public void deleteCompany(int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Company deleteCompany = (Company) session.get(Company.class,id);
            session.delete(deleteCompany);
            logger.info("deleted succesfully");
            session.getTransaction().commit();
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
    public List<Company> listCompany() {
        Session session =null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Company> listCompany = session.createQuery("from Company order by ID").list();
            session.getTransaction().commit();
            return listCompany;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
}
