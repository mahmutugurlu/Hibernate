package com.tpe.hb01.basicannotations.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave08 {

    public static void main(String[] args) {

        Student08 student1=new Student08(1001,"Ali Can",99);
        Student08 student2=new Student08(1002,"Veli Han",89);
        Student08 student3=new Student08(1003,"Ayşe Can",99);
        Student08 student4=new Student08(1004,"Fatma Han",99);

        Course course1=new Course(11,"JDBC");
        Course course2=new Course(22,"Hibernate");

        //ilişkinin kurulduğu tarafta set edilmeli
        student1.getCourseList().add(course1);
        student1.getCourseList().add(course2);

        student2.getCourseList().add(course1);
        student2.getCourseList().add(course2);

        student3.getCourseList().add(course2);





        Configuration configuration = new Configuration().configure ().
                addAnnotatedClass (Student08.class).addAnnotatedClass (Course.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory ();

        Session session = sessionFactory.openSession ();

        Transaction transaction = session.beginTransaction ();

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);
        session.save(course1);
        session.save(course2);


        transaction.commit();
        session.close();
        sessionFactory.close();













    }


}
