package com.pac.demo;

import com.pac.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDemo2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student").list();

            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName='Gara'").list();

            System.out.println("\n\nStudents who have surname Gara");
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
