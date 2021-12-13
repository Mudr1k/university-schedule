package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Classroom;
import com.mudr1k.universityschedule.repository.ClassroomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class ClassroomServiceTest {

    @Autowired
    private ClassroomRepository classroomRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        var list = classroomRepository.findAll();
    }

    @Test
    void create() {
        Classroom classroom = new Classroom("800");
        classroomRepository.save(classroom);
        assertNotNull(classroom.getId());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}