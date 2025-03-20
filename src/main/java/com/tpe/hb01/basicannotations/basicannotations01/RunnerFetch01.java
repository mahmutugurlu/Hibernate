package com.tpe.hb01.basicannotations.basicannotations01;

import com.tpe.hb01.basicannotations.basicannotations01.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

//uygulamaya veritabanından data çekme:READ
public class RunnerFetch01 {
    public static void main(String[] args) {

/*
DB den data çekmek için:fetch işlemlerinde transactiona gerek yoktur
          Task:id=1001/1002/1003 olan öğrenciyi tüm fieldlarıyla getirmek(fetch) istiyoruz.
           1) sessionın metodu:get():en pratik ama kullanım alanı kısıtlı
           2) SQL : DB ce
           3) HQL(Hibernate Query Language): Javaca

           HQL (Hibernate Query Language), Hibernate ORM tarafından sağlanan,
           nesne odaklı bir sorgulama dilidir. HQL, SQL'e benzer şekilde çalışır
           ancak doğrudan veritabanı tablolarıyla değil,
           Java sınıfları (entity'ler) ve onların özellikleriyle çalışır

*/
        //configure() parametresiz olarak kullanılırsa:default olarak
        //hibernate.cfg.xml ismindeki dosyayı bulur. Bunun icin bu adi kullanmaliyiz
        Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        SessionFactory sf =config.buildSessionFactory();
        Session session =sf.openSession();

        //get (Session classa ait get methotu)
        Student student=session.get(Student.class,1001);
        System.out.println("--------------get metodu-----------------");
        System.out.println(student);


        //SQL
        String sql="SELECT * FROM t_student WHERE id=1002";
        Object[] student2= (Object[]) session.createSQLQuery(sql).uniqueResult();//id,name,grade
        //uniqueResult():sorgunun tek satır getireceğini biliyorsak kullanılır
        //geriye bir satırdan birden fazla data geldiği için data tipleri farklı
        //old için Object[] içine alınır.

        System.out.println("--------------SQL-----------------");
        System.out.println(Arrays.toString(student2));

        //HQL:Javaca : daha aşinayız
        String hql="FROM Student WHERE id=1003";
        Student student3=session.createQuery(hql, Student.class).uniqueResult(); //Student.class bunu hql sorgu sonucu hangi data tipinde olcagini göstermek icin yazdik
        System.out.println("--------------HQL-----------------");
        System.out.println(student3);


        //tüm kayıtları çekelim
        //hql ile
        List<Student> studentList =session.createQuery("FROM Student", Student.class).getResultList();
        //getResultList birden fazla kayıt geleceği zaman kullanılır, sonuclari list olarak aliriz
        System.out.println("--- Tüm öğrenciler ---");
        studentList.forEach(System.out::println);

        //sql ile tüm kayıtları çekelim:exercise ?????




        //HQL ile grade değeri 98 olan öğrencilerin id ve name bilgilerini getirelim
        //SQL ile :exercise
        String hql2="SELECT s.id, s.name FROM Student s WHERE s.grade=98";
        List<Object[]> resultList=session.createQuery(hql2).getResultList();
        System.out.println("-------HQL ile sadece id ve name-----------");
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));


        //HQL ile
        //ismi Harry Potter olan öğrencileri getirelim
        String hql3="SELECT s FROM Student s WHERE s.name='Harry Potter'";
        List<Student> resultList2=session.createQuery(hql3, Student.class).getResultList();
        resultList2.forEach(System.out::println);

        //HQL:tüm öğrencilerin sadece isimlerini getirelim
        List<String> resultList3=session.createQuery("SELECT name FROM Student",String.class).getResultList();
        resultList3.forEach(System.out::println);


        session.close();
        sf.close();


    }
}