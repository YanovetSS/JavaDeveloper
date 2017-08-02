package module03.exampleHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by MakeMeSm1Le- on 14.07.2017.
 */

public class CRUDForSTUDENT {
    public static void main(String[] args) {
        //create student entity object
        Student student = new Student();

        student.setStudentName("Nazar");
        student.setRollNumber(380681421);
        student.setCourse("GoJava6");

        //create session factory object;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //gettion transaction object from session object
        session.beginTransaction();

        session.save(student);
        System.out.println("Inserted Succesfully");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
