package com.tpe.hb01.basicannotations.basicannotations01;

import javax.persistence.*;

@Entity
public class StudentCopy {



    @Id // id sütununa PK kisitlanmasinin eklenmesini saglar
    private Integer id;


    @Column(name = "student_name" , nullable = false, unique = true, length = 50)//@Column kullanarak field ismini degistirdik
    // ve belli kisitlamalar verdik

    private String name;
    private int grade;

    @Transient //DB de bu fielda karşılık bir sütun oluşmasını engeller, tabloda yer almayacak
    private int bonus;//sadece hesaplamalar için kullanılacak
    //bonus değerinin tabloda yer almasına gerek yok

 //   @Lob  //büyük boyutta datalar (BLOB,CLOB) saklanır:resim, video, ses , büyük metin....
  //  private byte[] image;


    //default constructor var


    //getter-setter

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


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
