package com.company.StudentCrudSpringMVC.controller;

import java.util.List;

import com.company.StudentCrudSpringMVC.entity.Student;
import com.company.StudentCrudSpringMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/list")
    public String listStudents(Model theModel) {

        List<Student> students = studentService.findAll();

        theModel.addAttribute("students", students);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Student student = new Student();

        theModel.addAttribute("student", student);

        return "students/student-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,
                                    Model theModel) {

        Student students = studentService.findById(theId);

        theModel.addAttribute("student", students);

        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {

        studentService.save(student);

        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {

        studentService.deleteById(theId);

        return "redirect:/students/list";

    }
}

















