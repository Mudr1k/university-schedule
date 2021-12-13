package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Subject;
import com.mudr1k.universityschedule.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/v1/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "")
    public List<Subject> getAllSubjects() {
        return subjectService.findAll();
    }

    @PostMapping(path = "")
    public void create(@RequestBody Subject subject) {
        subjectService.create(subject);
    }

    @PutMapping(path = "")
    public void update(@RequestBody Subject subject) {
        subjectService.update(subject);
    }

    @DeleteMapping(path = "/{subjectId}")
    public void delete(@PathVariable Long subjectId) {
        subjectService.delete(subjectId);
    }
}
