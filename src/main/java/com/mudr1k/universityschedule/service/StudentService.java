package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Student;
import com.mudr1k.universityschedule.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public void update(Student student) {
        var row = studentRepository.findById(student.getId());
        if (row.isPresent()) {
            var item = row.get();
            if (!student.getFirstName().isEmpty()) {
                item.setFirstName(student.getFirstName());
            }
            if (!student.getLastName().isEmpty()) {
                item.setLastName(student.getLastName());
            }
            item.setGroup(student.getGroup());
            studentRepository.save(item);
        }
    }


    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
