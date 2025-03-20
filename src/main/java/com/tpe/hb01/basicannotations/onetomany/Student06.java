package com.tpe.hb01.basicannotations.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="t_student06")
public class Student06 { //one

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;
    @OneToMany //tablolar arasında ilişkinin kurulmasını sağlar : iliski tablosu (Join table) olusturur
    @JoinColumn(name = "student_id")
    //@JoinColumn JOIN table iptal eder, book tablosuna FK sütunu ekler
    //@JoinColumn kullanılmazsa JOIN table oluşturulur.

    private List<Book> bookList = new ArrayList<>(); // many-- book ile iliski kurmak icin

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Student06() {
    }

    public Student06(Integer id, String name, int grade) {
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
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }



}
