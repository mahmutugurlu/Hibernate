package com.tpe.hb01.basicannotations.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book { //many tarafi
    @Id
    private Integer book_id;


    private String name;




    public Book() {
    }

    public Book(Integer book_id, String name) {
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


    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                '}';
    }
}
