package com.mudr1k.universityschedule.repository;

import com.mudr1k.universityschedule.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    Optional<Classroom> findClassroomByNumber(String number);
}
