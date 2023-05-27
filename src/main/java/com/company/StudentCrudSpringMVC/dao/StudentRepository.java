package com.company.StudentCrudSpringMVC.dao;

import com.company.StudentCrudSpringMVC.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
