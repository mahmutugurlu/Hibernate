package com.tpe.hb01.basicannotations.onetoone03;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



    @Entity
    @Table(name = "t_student03")
    public class Student03 {

        @Id
        private Integer id;

        @Column(name = "student_name",nullable = false)
        private String name;
        private int grade;

        public Student03() {
        }

        public Student03(Integer id, String name, int grade) {
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
            return "Student03{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", grade=" + grade +
                    '}';
        }


    }



