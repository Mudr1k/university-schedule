package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Classroom;
import com.mudr1k.universityschedule.repository.ClassroomRepository;
import com.mudr1k.universityschedule.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    public void create(Classroom classroom) {
        if (classroomRepository.findClassroomByNumber(classroom.getNumber()).isPresent()) {
            throw new RestApiException("The classroom '" + classroom.getNumber() + "' already exists");
        }
        classroomRepository.save(classroom);
    }

    public void update(Classroom classroom) {
        Optional<Classroom> row = classroomRepository.findById(classroom.getId());
        if (row.isPresent()) {
            Classroom item = row.get();
            if (!classroom.getNumber().isEmpty()) {
                item.setNumber(classroom.getNumber());
            }
            classroomRepository.save(item);
        }
    }

    public void delete(Long classroomId) {
        classroomRepository.deleteById(classroomId);
    }
}
