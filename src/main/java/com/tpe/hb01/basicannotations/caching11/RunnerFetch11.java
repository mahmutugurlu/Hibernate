package com.tpe.hb01.basicannotations.caching11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {

    /*
1)  First Level Cache --->
            * nesne için kullanılır
            * defaultta açık geliyor , kapatma durumu yok
            * Aynı session içinde kayıt alır
            * session kapanınca içindekiler silinir

2) Second Level Cache --->
            * nesne için kullanılır
            * Defaultta kapalıdır
            * Session factory seviyesinde cacheleme yapar, yani farklı
                    sessionlar arasında data kullanılabiliyor
            * hibernate.cfg.xml den active edilebilir
            *aynı data aynı sessionda first level cacheden gelir,
             aynı data farklı sessionda second level cacheden gelir.


3) Query Cache
            * Query ler için kullanılıyor
            * hibernate.cfg.xml den active edilebilir
            * second level cache ile kullanılabilir
            * aynı sorgunun sonucu cache e alınır.

 */

        public static void main(String[] args) {


            Configuration configuration = new Configuration().configure().
                    addAnnotatedClass(Student11.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session = sessionFactory.openSession();


            System.out.println("*********************************id:1 olan öğrenci için ilk get işlemi");
            Student11 student1 = session.get(Student11.class, 1);
            System.out.println(student1);//DB

            //bazı kodlar


            System.out.println("*********************************id:1 olan öğrenci için ikinci get işlemi");
            Student11 student2 = session.get(Student11.class, 1);
            System.out.println(student2);//1.level cache


            session.close();//1.level cache temizlenir
            Session session2 = sessionFactory.openSession();

            System.out.println("*********************************id:1 olan öğrenci için farklı sessionda get işlemi");
            Student11 student3 = session2.get(Student11.class, 1);
            System.out.println(student3);//DB

            System.out.println("*********************************id:1 olan öğrenci için farklı sessionda get işlemi");
            Student11 student4 = session2.get(Student11.class, 1);
            System.out.println(student4);//1.level cache

            session2.close();
            sessionFactory.close();


        }




}
