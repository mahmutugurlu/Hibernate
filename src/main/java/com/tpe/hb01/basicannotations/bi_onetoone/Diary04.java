package com.tpe.hb01.basicannotations.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Diary04 { //iliski sahibi bu class (owner of relation)


    @Id
    private Integer id;
    private String diaryName;

    @OneToOne//diary ile t_student03 arasında 1-1 ilişki kurulmasını sağlar
    //bunun için diary tablosuna FK ekler: default ismi:student_id
    @JoinColumn(name = "std_id",unique = true)//OPSİYONEL:isim değştirme, unique const. ekleme...
    private Student04 student;//günlük hangi öğrenciye ait:one

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }


    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", diaryName='" + diaryName + '\'' +
                ", student=" + student +
                '}';
    }
}
