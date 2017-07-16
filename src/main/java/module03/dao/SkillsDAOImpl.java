package module03.dao;

import module03.Utils.HibernateUtil;
import module03.model.Skills;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 16.07.2017.
 */
public class SkillsDAOImpl implements SkillsDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompaniesDAOImpl.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void addSkill(Skills skills) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(skills);
            logger.info("Save Skills succesfully");
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
    public void readSkill(int id) {
        Session session= null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Skills skills = (Skills) session.get(Skills.class,id);
            logger.info("Readed succesfully: " +skills);
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
    public void updateSkill(String name, int id) {
        Session session =  null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Skills updCompany  = (Skills) session.get(Skills.class,id);
            updCompany.setSkillDeveloper(name);
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
    public void deleteSkill(int id) {
        Session session = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Skills deleteSkill = (Skills) session.get(Skills.class,id);
            session.delete(deleteSkill);
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
    public List<Skills> listCompany() {
        Session session =null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Skills> listCompany = session.createQuery("from Skills order by ID").list();
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
