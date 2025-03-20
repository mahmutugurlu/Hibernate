package com.tpe.hb01.basicannotations.bi_onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

    public static void main(String[] args) {

        Student04 student1=new Student04(1001,"Ali Can",99);
        Student04 student2=new Student04(1002,"Ali Han",99);
        Student04 student3=new Student04(1003,"Veli Can",99);

        Diary04 diary1=new Diary04();
        diary1.setId(11);
        diary1.setDiaryName("X");

        Diary04 diary2=new Diary04();
        diary2.setId(22);
        diary2.setDiaryName("Y");

        Diary04 diary3=new Diary04();
        diary3.setId(33);
        diary3.setDiaryName("Z");

        //FK sütununa değerlerin eklenmesi için
        //ilişkinin sahibi olan tarafta set etmeliyiz.
        diary1.setStudent(student1);//FK sütununa std_id değeri eklenir
        diary2.setStudent(student2);

        //ilşkinin diğer yönü mappedBy tarafından otomatik olarak yapılır
//        student1.setDiary(diary1);//buna gerek yok
//        student2.setDiary(diary2);



        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

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
