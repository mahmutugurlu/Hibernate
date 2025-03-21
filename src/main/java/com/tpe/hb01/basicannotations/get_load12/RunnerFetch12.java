package com.tpe.hb01.basicannotations.get_load12;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch12 {

    /*
   get -> dönen objeye hemen ihtiyaç duyulursa get kullanılır.
       -> hemen db ye başvurur
       -> obje yoksa null döner
       -> id ile obje olduğuna emin değilsek get kullanılmalı

   load -> proxy(gölge) döner
        -> hemen db ye başvurmaz->ne zaman ihtiyaç duyulursa gerçek nesneyi döner
        -> obje yoksa not found exception fırlatır
        -> id ile obje olduğuna eminsek load kullanılmalı
        -> objeye reference olarak ihtiyaç duyulursa kullanılmalı

 */

    public static void main(String[] args) {

        Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student12.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        //get

        System.out.println("---------------get metodu öncesi");
        Student12 student=session.get(Student12.class,1);
        System.out.println("---------------get metodu sonrası");
        System.out.println("ID :"+student.getId());
        System.out.println("Öğrencinin adı : "+student.getName());

        //load
        System.out.println("---------------load metodu öncesi");
        Student12 student2=session.load(Student12.class,2);
        System.out.println("---------------load metodu sonrası");
        System.out.println("ID : "+student2.getId());
        System.out.println("Öğrencinin adı : "+student2.getName());

//        printStudent(Student12 student){
//            //burada kodlar var
//        ///...................
//
//        student2.getName();//tam olarak bu satırda DB ye gidecek
//        }
//        printStudent(student2);


//Not: get hemen database gider, load ihtiyac duydugunda gider

        //load metodu olmayan bir deger icin kullanildiginda hata firlatir, get ise null döndürür



//        printStudent(Student12 student){
//            //burada kodlar var
//        ///...................
//
//        student2.getName();//tam olarak bu satırda DB ye gidecek
//        }
//        printStudent(student2);

        //tabloda olmayan bir kayıt için kullanılırsa
        //get
        Student12 student3=session.get(Student12.class,99);
        if (student3!=null) {
            System.out.println(student3);//null
            System.out.println(student3.getName());//NullPointerException
        }else {
            System.out.println("öğrenci bulunamadı");
        }

        //load
        try {
            Student12 student4=session.load(Student12.class,99);//proxy
            // System.out.println(student4);//ObjectNotFoundException
        }catch (ObjectNotFoundException e){
            System.out.println("öğrenci bulunamadı");

        }

        //  printStudent(student4)










        session.close();
        sessionFactory.close();







    }
}
