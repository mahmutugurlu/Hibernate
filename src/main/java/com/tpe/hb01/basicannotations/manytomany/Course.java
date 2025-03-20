package com.tpe.hb01.basicannotations.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    private Integer id;

    private String name;
    @ManyToMany(mappedBy = "courseList") //join table = course_t_student08:gerek yok, diger tarafta iliski kurduk mappedBy ile takip et demek yeterli
                                        //mappedBy ile iliski kurmak icin iliskinin sahibi olan classta olusturdugumuz degisknin adini yazariz
    private List<Student08> studentList=new ArrayList<>();

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;

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

    public List<Student08> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student08> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}