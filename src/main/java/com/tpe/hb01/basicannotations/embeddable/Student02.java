package com.tpe.hb01.basicannotations.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id
    //@Column(name = "std_id")
    private Integer id;

    @Column(name = "Student_name",nullable = false)
    private String name;
    private int grade;

    //yazışma adresi
//    private String street;
//    private String city;
//    private String country;
//    private String zipcode;

    @Embedded//gömülü : OPSİYONEL -- @Embeddable anotasyonuyla Adress klasindaki fieldleri Student02 klasi araciligilya
                             //olustrudgumuz tabloya ekledik
    private Address address;




    //paramsiz const:hibernate fetch işlemlerinde default const kullanır.
    public Student02() {
    }

    //paramli constructor
    public Student02(Integer id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }


    //getter-setter

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }




}
