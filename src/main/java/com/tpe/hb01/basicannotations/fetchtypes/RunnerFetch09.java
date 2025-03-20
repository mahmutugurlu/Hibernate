package com.tpe.hb01.basicannotations.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();


        //student getirelim(onetomany):LAZY-->EAGER
        Student09 student=session.get(Student09.class,1001);
//        System.out.println(student.getBookList());

        //book getirelim(manytoone):EAGER-->LAZY
        Book09 book=session.get(Book09.class,33);
        //System.out.println(book.getStudent());





        session.close();
        sessionFactory.close();

        System.out.println(student.getBookList());

        //System.out.println(book.getStudent());
    }





}
