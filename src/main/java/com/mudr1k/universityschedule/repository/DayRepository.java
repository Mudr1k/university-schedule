package com.mudr1k.universityschedule.repository;

import com.mudr1k.universityschedule.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

    Optional<Day> findDayByName(String name);
}
