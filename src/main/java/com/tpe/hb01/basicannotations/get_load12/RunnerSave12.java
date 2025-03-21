package com.tpe.hb01.basicannotations.get_load12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {

    public static void main(String[] args) {

        Student12 student1=new Student12("Ali",99);
        Student12 student2=new Student12("Veli",98);


        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();


        session.save(student1);
        session.save(student2);


        transaction.commit();
        session.close();
        sessionFactory.close();













    }




}
