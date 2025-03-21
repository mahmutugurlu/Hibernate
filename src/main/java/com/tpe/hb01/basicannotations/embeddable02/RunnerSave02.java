package com.tpe.hb01.basicannotations.embeddable02;

public class RunnerSave02 {

    public static void main(String[] args) {


        Student02 student1=new Student02(1001,"Ali Can",99);
        Student02 student2=new Student02(1002,"Ali Han",99);
        Student02 student3=new Student02(1003,"Veli Can",99);

        Address address1=new Address("Orange Street","London","UK","12234");
        Address address2=new Address("Apple Street","New York","USA","12899");

        student1.setAddress(address1);
        student2.setAddress(address2);
        student3.setAddress(address2);

       /* Configuration configuration=new Configuration().configure().
                addAnnotatedClass(Student.class).addAnnotatedClass(StudentCopy.class);

        SessionFactory sessionFactory =configuration.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();*/

        //Configuration configuration=new Configuration().configure().
         //       addAnnotatedClass(Student02.class);

       // SessionFactory sessionFactory =configuration.buildSessionFactory();

       // Session session =sessionFactory.openSession();

      //  Transaction transaction =session.beginTransaction();

    }
    
}
