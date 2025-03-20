package com.tpe.hb01.basicannotations.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Book09 { //many


    @Id
    private Integer id;
    private String name;

    //cascade = CascadeType.ALL:entitye uygulanan işlemi aynen ilişkili olan objeye aktarır
    // örn:bir kitabı DB ye kaydettiğimde bu kitabın
    // sahibi olan öğrenciyi de otomatik olarak kaydeder

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY) //Eager olan default degerini fetch attribute ile lazy olarak degistirdik
    private Student09 student;

    public Book09() {
    }

    public Book09(Integer id, String name) {
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

    public Student09 getStudent() {
        return student;
    }

    public void setStudent(Student09 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }









}
