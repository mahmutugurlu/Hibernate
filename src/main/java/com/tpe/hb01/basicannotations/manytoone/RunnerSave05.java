package com.tpe.hb01.basicannotations.manytoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {


        Student05 student1=new Student05(1001,"Jack",99);
        Student05 student2=new Student05(1002,"Harry",95);
        Student05 student3=new Student05(1003,"Fred",89);
        Student05 student4=new Student05(1004,"Barnie",98);

        University university=new University(11,"TPE University");
        University university2=new University(22,"NSB University");

        student1.setUniversity(university); // fieldleri set ederek hibernate iliski kurmasini saglariz
        student2.setUniversity(university);
        student3.setUniversity(university2);



        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        session.save(student1); //sql deki insert into , yani kaydettik
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(university);
        session.save(university2);




        transaction.commit();
        session.close();
        sessionFactory.close();










    }
}
