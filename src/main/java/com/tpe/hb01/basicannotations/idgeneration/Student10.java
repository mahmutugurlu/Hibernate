package com.tpe.hb01.basicannotations.idgeneration;

import javax.persistence.*;

/*
IDENTITY:1 den başlar 1er artırarak id leri generate eder.
TABLE:id üretmek için tablo oluşturur,EN YAVAŞ, bu sebeple pek tercih edilmez
SEQUENCE:id set oluşturur,başlangıç değeri verebiliriz,HIZLIDIR
AUTO:Kullanılan DB ye göre stratejiyi belirler
       Oracle DB - PostgreSQL ---> Sequence ( kontrolü developera bırakır, Id üretilirken
            başlangıç değeri veya kaç tane id cachelenecek bu gibi bilgileri developer setliyebilir)
       MySQL - Microsoft SQL   ---> IDENTITY ( kontrol DB de , kendi yapısına göre ıd oluşturur,
            içlerindeki en basitidir)
 */

@Entity
@Table(name = "t_student10")
public class Student10 {

    @Id
    @GeneratedValue(generator = "sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence",
            sequenceName = "std_sequence",//default:hibernate_sequence
            initialValue = 1000,//default:1
            allocationSize = 5//id setinde kaç adet id olacak, default:50
    )
    private Integer id;




    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




}
