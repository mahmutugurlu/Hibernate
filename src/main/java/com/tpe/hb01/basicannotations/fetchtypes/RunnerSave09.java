package com.tpe.hb01.basicannotations.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {

    public static void main(String[] args) {

        Student09 student1 = new Student09(1001,"Ali",70);
        Student09 student2 = new Student09(1002,"Veli",70);
        Student09 student3 = new Student09(1003,"Can",70);
        Student09 student4 = new Student09(1003,"Deniz",70);

        Book09 book1=new Book09(11,"A Book");
        Book09 book2=new Book09(22,"B Book");
        Book09 book3=new Book09(33,"C Book");
        Book09 book4=new Book09(44,"D Book");
        Book09 book5=new Book09(55,"E Book");

        //iliskinin kurulmasi icin set edilmeli
        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student3);

        //student5 bir kitap tarafından referans alınmadığı için persist edilmedi
        //diğerleri cascadeType.ALL->cascadeType.PERSIST in sonucu olarak
        //bir kitap tarafından ref. alındığı için kitap tabloya eklenince
        //öğrenci de tabloya otomatik eklendi.


        //student1.getBookList();//henüz boş--tablodan kayıt çekerken mappedBy ile doldurur
        //ÖNEMLİ:cascadeType.ALL u ilişkinin map edildiği tarafta kullanırsak
        //yani öğrenciyi ekleyince kitaplar da tabloya eklensin istersek
        //bu durumda bu tarafta da set işlemi yapılmalı
        //student1.getBookList().add(book1);




        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);




        transaction.commit();
        session.close();
        sessionFactory.close();








    }
}
