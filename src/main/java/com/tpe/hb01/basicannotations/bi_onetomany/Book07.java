package com.tpe.hb01.basicannotations.bi_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book07 { //many : iliskinin sahibi,  cünkü iliski kurulan anatasyon burada

    @Id
    private Integer book_id;
    private String name;

   @ManyToOne //ilişkiyi kurar:FK ekler
    //@JoinColumn:opsiyonel

   private Student07 student; // one : bu kitap kime ait

    public Book07() {
    }

    public Book07(Integer book_id, String name) {
        this.book_id = book_id;
        this.name = name;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student07 getStudent() {
        return student;
    }

    public void setStudent(Student07 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                '}';
    }
















}
