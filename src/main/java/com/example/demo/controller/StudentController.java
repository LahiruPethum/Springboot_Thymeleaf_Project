package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    //disply students
    @GetMapping("/")
    public String viewStudents(Model model){
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }
}
