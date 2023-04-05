package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/addNewStudentForm")
    public String addNewStudent(Model model){
        Student student =new Student();
        model.addAttribute("student", student);
        return "newStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Student student = studentService.getStudentById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }

}
