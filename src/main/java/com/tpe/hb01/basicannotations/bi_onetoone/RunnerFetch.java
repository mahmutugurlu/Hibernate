package com.tpe.hb01.basicannotations.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //id:1001 olan öğrenciyi getirelim
        Student04 student=session.get(Student04.class,1001);
        System.out.println(student);

        //bu öğrencinin günlüğü hangisi?
        System.out.println(student.getDiary());

        //id:22 olan günlüğü getirelim
        Diary04 diary=session.get(Diary04.class,22);
        System.out.println(diary.getStudent());


        // Task 1: Günlüğü olan öğrenci ve sahibi olan günlüklerin
        //student name ve diary name fieldlarını getirelim.

        System.out.println("---------------------------------------------------------");
        String hql="SELECT s.name, d.diaryName FROM Student04 s INNER JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList =session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));

        /*
           List<Diary04> DiaryList =session.createQuery("FROM Diary04 WHERE student != null", Diary04.class).getResultList();
        DiaryList.forEach(t -> System.out.println(t.getStudent().getName() +" --> "+t.getDiaryName()));


         */


        // !!! Task 2: Tüm öğrencilerin
        //student name ve varsa diary name fieldlarını getirelim.

        System.out.println("---------------------------------------------------------");

        String hql2="SELECT s.name, d.diaryName FROM Student04 s LEFT JOIN Diary04 d ON s.id=d.student";//d.student.id
        String hql3="SELECT s.name, d.diaryName FROM Student04 s RIGHT JOIN Student04 d ON s.id=d.student"; //2.yol
        List<Object[]> resultList2 =session.createQuery(hql).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));


        // Task 3 : tüm günlük ve öğrencilerin isimlerini getirelim.

        System.out.println("---------------------------------------------------------");
        String hql4="SELECT s.name, d.diaryName FROM Student04 s FULL JOIN Diary04 d ON s.id=d.student";//d.student.id
        List<Object[]> resultList3 =session.createQuery(hql4).getResultList();
        resultList3.forEach(t-> System.out.println(Arrays.toString(t)));






        session.close();
        sessionFactory.close();





    }
}
