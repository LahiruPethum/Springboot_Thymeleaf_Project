package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepo.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepo.findById(id);
        Student student = null;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Student not found for id :: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepo.deleteById(id);
    }
}
