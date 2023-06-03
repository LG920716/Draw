package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "gender")
    Integer gender;

    @Column(name = "will_grouping")
    Boolean willGrouping;

    @Column(name = "group_number")
    Integer groupNumber;

    public Student(){}

    public Student(Integer id, String name, Integer gender, Boolean willGrouping, Integer groupNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.willGrouping = willGrouping;
        this.groupNumber = groupNumber;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Boolean getWillGrouping() {
        return willGrouping;
    }

    public void setWillGrouping(Boolean willGrouping) {
        this.willGrouping = willGrouping;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }
}
