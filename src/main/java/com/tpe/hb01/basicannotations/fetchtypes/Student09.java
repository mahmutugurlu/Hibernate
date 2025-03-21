package com.tpe.hb01.basicannotations.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student")
public class Student09 {

       /*
    2.taraf Many ise default olarak Lazy , One ise default olarak EAGER yapar :

    OneToMany       --> LAZY
    ManyToMany      --> LAZY
    OneToOne        --> EAGER
    ManyToOne       --> EAGER

        //onetoone(student-diary)->std+diary(EAGER)
        //manytoone(std-uni)->std+uni ((EAGER))
        //onetomany(std-book)->std-book(LAZY)
        //manytomany(std-course)->std-course ve course-std(LAZY)
        //FetchTypes:Lazy(tembel)/Eager(hevesli)


    */

    @Id
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER) //cascade = CascadeType.ALL burada da kullanabiliriz-// default olarak lazy
                                                    //,fetch = FetchType.EAGER ile bir cok sonucu getirmesini saglariz
    private List<Book09> bookList=new ArrayList<>();

    public Student09() {
    }

    public Student09(Integer id, String name, int grade) {
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

    public List<Book09> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book09> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }







}
