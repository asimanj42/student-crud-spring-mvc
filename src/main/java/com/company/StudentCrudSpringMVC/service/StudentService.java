package com.company.StudentCrudSpringMVC.service;

import com.company.StudentCrudSpringMVC.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    void deleteById(Integer id);

}
