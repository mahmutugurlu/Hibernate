package com.tpe.hb01.basicannotations.caching11;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_student11")
@Cacheable // 2. seviye (cache de) önbellekte tutulmasina izin veriyorum
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)// hangi durumlarda cache kullanacagimizi belirtiyoruz
public class Student11 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    public Student11() {
    }

    public Student11(String name, int grade) {
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
        return "Student11{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }


}
