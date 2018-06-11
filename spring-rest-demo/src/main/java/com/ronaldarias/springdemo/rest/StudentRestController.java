package com.ronaldarias.springdemo.rest;


import com.ronaldarias.springdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Ronald", "Arias"));
        studentList.add(new Student("Bryan", "Zuniga"));
        studentList.add(new Student("David", "Mena"));

        return studentList;
    }
}
