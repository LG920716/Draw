package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PostMapping("/isTeacher")
    public boolean isTeacher(@RequestBody Integer password){
        return studentService.isTeacher(password);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/deleteAllStudents")
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer studentId,
                                           @RequestBody Student studentData){
        try {
            Student student = studentService.getById(studentId);
            student.setName(studentData.getName());
            student.setGender(studentData.getGender());
            student.setWillGrouping(studentData.getWillGrouping());
            student.setGroupNumber(studentData.getGroupNumber());
            studentService.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getGrouping")
    public ArrayList<Student> getGroupingStudent(){
        return studentService.getGroupingStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student read(@PathVariable Integer studentId){
        return  studentService.getById(studentId);
    }

}
