package com.tpe.hb01.basicannotations.onetoone03;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

    public static void main(String[] args) {




        Student03 student1=new Student03(1001,"Ali Can",99);
        Student03 student2=new Student03(1002,"Ali Han",99);
        Student03 student3=new Student03(1003,"Veli Can",99);



        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        Diary diary1=new Diary();
        diary1.setId(11);
        diary1.setDiaryName("X");

        Diary diary2=new Diary();
        diary2.setId(22);
        diary2.setDiaryName("Y");

        Diary diary3=new Diary();
        diary3.setId(33);
        diary3.setDiaryName("Z");

        //---------------------------------------------------------

        diary1.setStudent(student1);//diary1 ile student1 ilişkilendirdik
        diary2.setStudent(student2);
        diary3.setStudent(student3);
        //DİKKAT:FK sütununa yani std_id ye unique ekledik: her  bir günlük farklı öğrenciye ait olmalı







        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);



        transaction.commit();
        session.close();
        sessionFactory.close();




    }
}
