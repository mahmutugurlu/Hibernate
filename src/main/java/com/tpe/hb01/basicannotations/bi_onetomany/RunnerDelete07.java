package com.tpe.hb01.basicannotations.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerDelete07 {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();


        Transaction tx= session.beginTransaction();

        // !!! Kitab bilgisi(ilişkisi) olan bir ogrenciyi silmek istersek
        // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir
        // 2.yol ) Cascade:CascadeType.REMOVE/orphanRemoval:true

        //id si 1002 olan ögrenciyi silelim
        Student07 student = session.get(Student07.class,1002);
        session.delete(student);

        //id:1001 olan öğrencinin kitap listesinden ilkini silelim
        Student07 student2=session.get(Student07.class,1001);
        student2.getBookList().remove(0);//1001:101,102-->102
       // student2.getBookList().set(0,null);//artık öğrencinin 101 idli kitabı yok

        //bir entity objesinin ilişkili olduğu objeyle ilişkisini kaldırırsak
        //studentın booklistesinden bir kitabı kaldırır veya null yaparsak
        //referansı olmayan bu objeyi(kitabı) tablodan siler

        //!!!bu senaryoda cascadeType.REMOVE bir şey yapmaz kitap tabloda kalır.

        //!!! orphanREMOVAL sadece @onetoone ve @onetomany anotasyonlarında kullanılır.

        //1)std-book(1-m):std kitabı iade etti-->listeden kaldırdık
        //                                    -->tablodan silmemeliyiz->orphanREMOVAL:false
        //2)customer-order-->sipariş listesi(1,2,3)
        //                -->siparişi iptal(1)-->sipariş listesi(2,3)
        //müşterinin kendisine özel oluşturduğu siparişi tabloda tutmaya gerek var mı->orphanREMOVAL:true





        tx.commit();
        session.close();
        sessionFactory.close();



    }
}
