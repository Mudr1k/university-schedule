package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Classroom;
import com.mudr1k.universityschedule.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/v1/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping(path = "")
    public List<Classroom> getAllClassrooms() {
        return classroomService.findAll();
    }

    @PostMapping(path = "")
    public void create(@RequestBody Classroom classroom) {
        classroomService.create(classroom);
    }

    @PutMapping(path = "")
    public void update(@RequestBody Classroom classroom) {
        classroomService.update(classroom);
    }

    @DeleteMapping(path = "/{classroomId}")
    public void delete(@PathVariable Long classroomId) {
        classroomService.delete(classroomId);
    }
}
