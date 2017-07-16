package module03.dao;

import module02.entities.Project;
import module03.Utils.HibernateUtil;
import module03.model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by MakeMeSm1Le- on 16.07.2017.
 */
public class ProjectsDAOImpl implements ProjectsDAO {
    private static final Logger logger = LoggerFactory.getLogger(CompaniesDAOImpl.class);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void addProject(Project project) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(project);
            logger.info("Save project succesfully");
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
    public void readProject(int id) {
        Session session= null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            module03.model.Project project = (module03.model.Project) session.get(module03.model.Project.class,id);
            logger.info("Readed succesfully: " +project);
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
    public void updateProject(String name, int id) {
        Session session =  null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            module03.model.Project updProject  = (module03.model.Project) session.get(module03.model.Project.class,id);
            updProject.setProjectName(name);
            session.update(updProject);
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
            module03.model.Project deleteProject = (module03.model.Project) session.get(module03.model.Project.class,id);
            session.delete(deleteProject);
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
    public List<module03.model.Project> listProject() {
        Session session =null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<module03.model.Project> listProject = session.createQuery("from Project order by ID").list();
            session.getTransaction().commit();
            return listProject;
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }
}
