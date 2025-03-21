package com.tpe.hb01.basicannotations.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //id:1002 olan öğrenciyi getirelim
        Student05 student=session.get(Student05.class,1002);
        System.out.println(student);
        System.out.println(student.getUniversity());



        //id:11 olan üniversitenin tüm öğrencilerini listeleyelim:HQL

        String hql="SELECT s FROM Student05 s WHERE s.university.id=:pid";//?1 - :pid hql böyle  2 sekilde parametre kullanabiliriz

        //s.university=11-->parametre olarak int verildiği için böyle kullanılamaz!!!
        //s.university=pid -->setParameter("pid",university) olabilir

        Query<Student05> query =session.createQuery(hql, Student05.class).setParameter("pid",11); //setParameter metodu ile parametreye deger verdik
        List<Student05> resultList =query.getResultList();
        resultList.forEach(t-> System.out.println(t));

        //1.level cacheden gelir
        System.out.println("******************************************");
        System.out.println(session.get(University.class, 11));

        //university.getStudents() seklinde bir field yok--tek yönlü ilişki: ancak SQL veya HQL ulaşılabilir.


        //tüm öğrencilerin isimlerini, notlarını ve üniversitelerinin isimlerini yazdıralım

        String hql2="SELECT s.name, s.grade, s.university.name FROM Student05 s"; //university fieldi oldugu icin Student kilassinda s.university.name seklinde hql de yazabiliriz
        List<Object[]> resultList2=session.createQuery(hql2).getResultList();
        for (Object[] o:resultList2){
            System.out.println(Arrays.toString(o));
        }



        session.close();
        sessionFactory.close();






    }
}
