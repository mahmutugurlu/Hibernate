package com.tpe.hb01.basicannotations.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private Integer id;
    private String diaryName;
    @OneToOne ////diary ile t_student03 arasında 1-1 ilişki kurulmasını sağlar
            //bunun için diary tablosuna FK ekler: default ismi:student_id

    @JoinColumn(name = "std_id",unique = true)//OPSİYONEL:isim değştirme, unique const. ekleme...
    private  Student03 student; //günlük hangi ögrenciye ait

    public Diary() {
    }

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }
}
