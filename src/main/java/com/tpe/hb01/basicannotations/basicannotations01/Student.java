package com.tpe.hb01.basicannotations.basicannotations01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // @Entity ile bu sinifin DB de bir tabloya karsilik gelmesini sagliyoruz, tablonun adı: student
@Table(name = "t_student")//tablonun ismini kendimiz verebiliriz.OPSİYONEL

public class Student {


    //hedef:
    //dataları persist etmek için bu classa karşılık bir tablo gerekli

    //tablonun sütunları:id,name,grade

    //hibernate(ORM) bizim için bu hedefi otomatik olarak yapar.

    //Entity:
//1-pk belirtilmeli:@Id
//2-default constructor tanımlanmalı:hibernate data çekerken kullanır



    @Id // id sütununa PK kisitlanmasinin eklenmesini saglar
    private Integer id;


    @Column(name = "student_name" , nullable = false, unique = true, length = 50)//@Column kullanarak field ismini degistirdik
                                            // ve belli kisitlamalar verdik

    private String name;
    private int grade;

    //default constructor var


    //getter-setter


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }








}
