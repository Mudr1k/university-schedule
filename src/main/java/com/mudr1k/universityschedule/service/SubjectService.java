package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Subject;
import com.mudr1k.universityschedule.repository.SubjectRepository;
import com.mudr1k.universityschedule.response.RestApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public void create(Subject subject) {
        if (subjectRepository.findSubjectByName(subject.getName()).isPresent()) {
            throw new RestApiException("The classroom '" + subject.getName() + "' already exists");
        }
        subjectRepository.save(subject);
    }

    public void update(Subject subject) {
        var row = subjectRepository.findById(subject.getId());
        if (row.isPresent()) {
            var item = row.get();
            if (!subject.getName().isEmpty()) {
                item.setName(subject.getName());
            }
            subjectRepository.save(item);
        }
    }

    public void delete(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
