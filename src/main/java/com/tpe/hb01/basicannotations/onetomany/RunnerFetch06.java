package com.tpe.hb01.basicannotations.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //id:1001 olan öğrencinin kitaplarını görelim
        Student06 student=session.get(Student06.class,1001);
        System.out.println(student);

        //id:101 olan kitabı görelim
        Book book=session.get(Book.class,101);
        System.out.println(book);

        //bu kitap kime ait?book.getStudent() metod yok ama HQL/SQL ile ulaşabiliriz

        String sql="SELECT s.id,s.student_name,s.grade FROM t_student06 s INNER JOIN book b " +
                "ON s.id=b.student_id";
        Object[] result= (Object[]) session.createSQLQuery(sql).uniqueResult();
        System.out.println("---------------------------------------------------");
        System.out.println(Arrays.toString(result));


        //hql ile: javaca
        String hql="SELECT s FROM Student06 s INNER JOIN s.bookList b WHERE b.book_id=101"; //iliskiyi bookList ile sagladigimiz icin onu yazdik
        Student06 student2=session.createQuery(hql, Student06.class).uniqueResult();
        System.out.println(student2);

        //name:'Jack' olan öğrencinin kitaplarını getirelim

        String sql2="SELECT b.book_id, b.name FROM book b INNER JOIN t_student06 s " +
                "ON b.student_id=s.id WHERE s.student_name='Jack'";

        String hql2="SELECT b.book_id, b.name FROM Student06 s INNER JOIN" +
                " s.bookList b WHERE s.name='Jack' ";

        List<Object[]> books =session.createQuery(hql2).getResultList();
        for (Object[] o:books){
            System.out.println(Arrays.toString(o));
        }




        session.close();
        sessionFactory.close();




    }
}
