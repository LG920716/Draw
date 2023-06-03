package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    void deleteAllStudents();

    ArrayList<Student> getGroupingStudents();

    boolean isTeacher(Integer password);

    Student getById(Integer studentId);
}
