package com.example.demo.service.implement;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public ArrayList<Student> getGroupingStudents() {
        List<Student> studentList = (List<Student>) studentRepository.findAll();
        ArrayList<Student> groupedStudents = new ArrayList<>();

        Collections.shuffle(studentList);
        int groupNumber = 1;
        for (Student student : studentList) {
            if (student.getWillGrouping()) {
                student.setGroupNumber(groupNumber % 2 + 1);
                groupedStudents.add(student);
                groupNumber++;
            }
        }

        studentRepository.saveAll(groupedStudents);

        return groupedStudents;
    }

    @Override
    public boolean isTeacher(Integer password) {
        if(password == 1234){
            return true;
        }
        return false;
    }

    @Override
    public Student getById(Integer studentId) {
        return studentRepository.getById(studentId);
    }
}
