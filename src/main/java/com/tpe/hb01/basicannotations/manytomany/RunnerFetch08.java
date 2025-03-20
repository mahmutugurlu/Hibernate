package com.tpe.hb01.basicannotations.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student08.class).addAnnotatedClass(Course.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //id:1001 olan öğrenciyi ve kurslarını görelim
        Student08 student=session.get(Student08.class,1001);
        System.out.println(student);
        System.out.println(student.getCourseList());

        //id:11 olan kursu ve kursu alan öğrencileri görelim
        System.out.println("----------------------------------------------------");
        Course course=session.get(Course.class,11);
        System.out.println(course);
        System.out.println(course.getStudentList());

        //student<->course
        //onetoone(student-diary)->std+diary(EAGER)
        //manytoone(std-uni)->std+uni ((EAGER))
        //onetomany(std-book)->std-book(LAZY)
        //manytomany(std-course)->std-course ve course-std(LAZY)
        //FetchTypes:Lazy(tembel)/Eager(hevesli)

        //not: cift tarafli iliski oldugu icin hql ya da sql kullanmaya gerek yok, java kodlari ile sorgu yapilabiliyor







        session.close();
        sessionFactory.close();







    }


}
