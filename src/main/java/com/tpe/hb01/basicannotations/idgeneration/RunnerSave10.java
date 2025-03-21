package com.tpe.hb01.basicannotations.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {


    public static void main(String[] args) {


        Student10 student1=new Student10();
        student1.setName("Jack");

        Student10 student2=new Student10();
        student2.setName("Harry");

        Student10 student3=new Student10();
        student3.setName("Sherlock");

        Student10 student4=new Student10();
        student4.setName("Mike");

        Student10 student5=new Student10();
        student5.setName("Mike");

        Student10 student6=new Student10();
        student6.setName("Mike");





        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student10.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        session.save(student1); //setlerde 5 tane id üretir, siralama yeni setin degeriyle devam eder
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(student5);
        session.save(student6);




        transaction.commit();
        session.close();
        sessionFactory.close();



    }




}
