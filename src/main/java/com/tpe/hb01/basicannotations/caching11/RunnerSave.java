package com.tpe.hb01.basicannotations.caching11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {



        Student11 student1=new Student11("Ali",99);
        Student11 student2=new Student11("Veli",98);
        Student11 student3=new Student11("Can",95);
        Student11 student4=new Student11("Deniz",89);


        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student11.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();


        //session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.persist(student1); //insert into

        //hibernate 6 dan sonra session.persist ilr kayit yapilir




        transaction.commit();
        session.close();
        sessionFactory.close();









    }

}
