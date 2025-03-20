package com.tpe.hb01.basicannotations.bi_onetoone;

import javax.persistence.*;

@Entity
@Table(name ="t_student04")
public class Student04 {

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;
    private int grade;
    @OneToOne(mappedBy = "student")//bu ilişki zaten diary04 tarafında kuruldu
    //diary04 classındaki studentın değerine göre eşleştirme yapar
    //student tablosunda fazladan FK daha eklemez!!!
    //mappedBy kullanılmazsa her iki tabloda da FK oluşur, buna gerek yok

    private Diary04 diary; //

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }

    public Student04() {
    }

    public Student04(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
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
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
               // ", diary=" + diary + hata almamiza sebep oludugu icin yoruma aldim,bu obje diary klassindaki tostring metoduna da götürdügü icin tostring methotu sonsuz döngüye sokar

                '}';
    }
}
