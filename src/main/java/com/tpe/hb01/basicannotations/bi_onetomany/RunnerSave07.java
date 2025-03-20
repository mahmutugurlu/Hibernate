package com.tpe.hb01.basicannotations.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {

    public static void main(String[] args) {

        Student07 student1=new Student07(1001,"Jack",99);
        Student07 student2=new Student07(1002,"Harry",95);
        Student07 student3=new Student07(1003,"Fred",89);
        Student07 student4=new Student07(1004,"Barnie",98);

        Book07 book1=new Book07(101,"Sefiller");
        Book07 book2=new Book07(102,"Suç ve Ceza");
        Book07 book3=new Book07(103,"Martin Eden");
        Book07 book4=new Book07(104,"Aforizmalar");

        //ilişkinin kurulduğu(sahibi) olan tarafta set işlemi yapılmalı, böylece FK ile iliski kurulur

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);

        //student1.getBookList().add(book1);-->mappedBy otomatik olarak yapar




        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);






        transaction.commit();
        session.close();
        sessionFactory.close();






    }


}
