package com.pac.demo;

import com.pac.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            System.out.println("Create student");
            Student tempStudent = new Student("Nia","Gara","Ngaasd");

            session.beginTransaction();

            System.out.println("Save");
            session.save(tempStudent);

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }
    }
}
