package com.tpe.hb01.basicannotations.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

    public static void main(String[] args) {



        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //id:101 olan kitabın sahibi kim?

 //       Book07 book =session.get(Book07.class,101);
  //      System.out.println(book.getStudent());

        //id:1002 olan öğrencinin kitaplarını görelim.

     //   Student07 student=session.get(Student07.class,1002);
     //   System.out.println(student.getBookList());

        //bi_directional : student <-> book

        //db'de değişikliklerin kalıcı olması için transaction gereklidir
        //aksi halde exception fırlatılır.


        Transaction tx = session.beginTransaction(); // silme islemi icin transaction olusturduk

        //book07 tablosundaki tüm kayıtları silelim
        String hql="DELETE FROM Book07";
        int deletedBooks=session.createQuery(hql).executeUpdate();
        System.out.println("deletedBooks : "+deletedBooks);

        //student07 tablosundaki tüm kayıtları silelim
        String hql2="DELETE FROM Student07";
        int deletedStudents=session.createQuery(hql2).executeUpdate();
        System.out.println("deletedStudents = " + deletedStudents);

        //İsmi Sefiller olan kitabı HQL ile silelim.
        String hql3="DELETE FROM Book07 b WHERE b.name='Sefiller' ";
        int deletedBooks2=session.createQuery(hql3).executeUpdate();
        System.out.println("deletedBooks : "+deletedBooks2);








        tx.commit();
        session.close();
        sessionFactory.close();



    }
}
