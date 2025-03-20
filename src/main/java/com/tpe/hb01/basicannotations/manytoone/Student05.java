package com.tpe.hb01.basicannotations.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 { //many , yani cok ögrenci var tek üniversite var

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;
    private int grade;

    private LocalDateTime createOn; //student tabloya eklendigi zaman
    @ManyToOne //t_student05 ile university tablosu arasında M-1 ilişki kurar
                //t_student05 tablosuna FK ekleyerek ilişkiyi ekler :university_id
                //Studentta da university sutunu oluşur , fk olur o da
    private University university;


    public Student05() {
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Student05(Integer id, String name, int grade) {
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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    @PrePersist //kalici hale getirmeden önce bu metod cagirilacak
    public void setCreateOn() {
        this.createOn = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                '}';
    }
}
