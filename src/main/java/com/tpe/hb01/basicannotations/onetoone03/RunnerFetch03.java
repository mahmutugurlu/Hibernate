package com.tpe.hb01.basicannotations.onetoone03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

    public static void main(String[] args) {


        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();


        //id:1001 olan öğrenciyi getirelim
        Student03 student=session.get(Student03.class,1001);
        System.out.println(student);

        System.out.println("******************************************");

        //id:11 olan günlüğü getirelim
        Diary diary=session.get(Diary.class,11);
        System.out.println(diary);


        System.out.println("******************************************");
        //id si 11 olan günlük kime ait

        System.out.println(diary.getStudent());//tekrar DB ye gitmeye gerek yok

        // id : 1001 olan ögrencinin günlügü hangisidir

        Student03 student2 = session.get(Student03.class,1002);

        System.out.println("******************************************");

        //student2.getDiary();-->java kodlarıyla ulaşamıyoruz.

        String diaryname=session.
                createQuery("SELECT d.diaryName FROM Diary d WHERE d.student=1002 ", String.class).uniqueResult();


        System.out.println(diaryname);



        session.close();

        sessionFactory.close();













    }

}
