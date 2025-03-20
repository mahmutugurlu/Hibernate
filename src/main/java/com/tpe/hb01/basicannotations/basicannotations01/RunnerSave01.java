package com.tpe.hb01.basicannotations.basicannotations01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {

        Student student1=new Student();
        student1.setId(1001);
        student1.setName("Jack Sparrow");
        student1.setGrade(99);

        Student student2=new Student();
        student2.setId(1002);
        student2.setName("Harry Potter");
        student2.setGrade(98);

        Student student3=new Student();
        student3.setId(1003);
        student3.setName("Sherlock Holmes");
        student3.setGrade(98);


        //configure metoduna parametre girilmezse defaultta "hibernate.cfg.xml"
        // dosyasına göre konfig. yapar.

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).addAnnotatedClass(StudentCopy.class);

        //Burada konfigürasyon ayarlarini yaptik, öncelikle olusturdugumuz xml dosyasini tanittik ve sonra da olusturdumuz
        //klasslari tanittik



        SessionFactory sessionFactory = configuration.buildSessionFactory();// configuration nesnesi araciligiyla
        //sessiom Factory degiskenini olusturduk
        //session nesneleri oluşturmak için kullanılır
        //genellikle tüm uygulamada sadece 1 tane SF yeterlidir.


         Session session = sessionFactory.openSession(); //DB ile ilgili tüm islemler icin metodlara sahiptir
        //DB oturumunu temsil eder, uygulamada birden fazla session açılabilir.

        //hibernate auto-commit öz. default olarak false(yani kapalıdır.)
        Transaction transaction =session.beginTransaction(); // transaction baslattik

        //student1 nesnesini tabloya kaydedelim

        session.save(student1);//insert into t_student values(1001,...)


        transaction.commit();//transactionı onaylar ve sonlandırır
        session.close();
        sessionFactory.close();









    }



}
