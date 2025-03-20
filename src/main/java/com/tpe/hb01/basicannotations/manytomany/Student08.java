package com.tpe.hb01.basicannotations.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student08")
public class Student08 { //iliskinin sahibi

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    @ManyToMany//ilişkiyi kurar:JOIN TABLE oluşturur
    @JoinTable(name = "student_course", // olusan tablo üzerinde degisiklikler yaptik, isim vb
            joinColumns = {@JoinColumn(name = "std_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courseList=new ArrayList<>();//many

    public Student08() {
    }

    public Student08(Integer id, String name, int grade) {
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student08{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
