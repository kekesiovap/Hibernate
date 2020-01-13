package com.pac.demo;

import com.pac.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            session=factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: "+studentId);

            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Updating student...");
            myStudent.setFirstName("Nia");

            session.getTransaction().commit();

            //session=factory.getCurrentSession();
            //session.beginTransaction();

            //System.out.println("Update email for all students...");
            //session.createQuery("Update Student set email='mail@mail.sk'").executeUpdate();

            //session.getTransaction().commit();

            System.out.println("Done.");
}
        finally {
            factory.close();
        }
    }
}
