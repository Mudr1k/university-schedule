package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Student;
import com.mudr1k.universityschedule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping(path = "")
    public void create(@RequestBody Student student) {
        studentService.create(student);
    }

    @PutMapping(path = "")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }
}
