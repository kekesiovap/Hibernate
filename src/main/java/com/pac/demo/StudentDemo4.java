package com.pac.demo;

import com.pac.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            int studentId = 4;

            session=factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: "+studentId);

            Student myStudent = session.get(Student.class, studentId);

            //System.out.println("Deleting student: "+myStudent);
            //session.delete(myStudent);

            System.out.println("Deleting student with id=3");
            session.createQuery("delete from Student where id=3").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done.");
        }
        finally {
            factory.close();
        }
    }
}