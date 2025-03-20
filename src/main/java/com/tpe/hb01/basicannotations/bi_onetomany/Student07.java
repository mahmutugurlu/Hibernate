package com.tpe.hb01.basicannotations.bi_onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "t_student07")
public class Student07 { //one


    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    //orphanRemoval:true/cascade = CascadeType.REMOVE
    // parent tablodan(student) satır silmek istediğimizde önce ilişkili olduğu
    //satırları(bookList) diğer tablodan(book) siler, ardından parenttan silme işlemi yapar.
    //yani aşamalı(kademeli) silme işlemini otomatik yapar.

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    //mappedBy ile kurulan iliski takip edilir, cift yönlü iliskilerde kullanilir, otomatik eslestirir
    //ilişki kurar:join table oluşturur, gerek yok,diğer tarafta ilişki kuruldu
    private List<Book07> bookList=new ArrayList<>();//many

    public Student07() {
    }

    public Student07(Integer id, String name, int grade) {
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

    public List<Book07> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book07> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }












}
