package com.tpe.hb01.basicannotations.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {
    @Id
    private Integer id;

    private String name;

    public University() {
    }

    public University(Integer id, String name) {
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

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
