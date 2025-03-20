package com.tpe.hb01.basicannotations.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {

    public static void main(String[] args) {

        Student06 student1=new Student06(1001,"Jack",99);
        Student06 student2=new Student06(1002,"Harry",95);
        Student06 student3=new Student06(1003,"Fred",89);
        Student06 student4=new Student06(1004,"Barnie",98);


        Book book1=new Book(101,"Sefiller");
        Book book2=new Book(102,"Suç ve Ceza");
        Book book3=new Book(103,"Martin Eden");
        Book book4=new Book(104,"Aforizmalar");


        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student2.getBookList().add(book3);
        student3.getBookList().add(book4);




        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);



        transaction.commit();
        session.close();
        sessionFactory.close();





    }
}
