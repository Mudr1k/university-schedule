package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Schedule;
import com.mudr1k.universityschedule.entity.Student;
import com.mudr1k.universityschedule.repository.ScheduleRepository;
import com.mudr1k.universityschedule.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final StudentRepository studentRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, StudentRepository studentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.studentRepository = studentRepository;
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public void create(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void update(Schedule schedule) {
        var row = scheduleRepository.findById(schedule.getId());
        if (row.isPresent()) {
            var item = row.get();
            item.setDay(schedule.getDay());
            item.setGroup(schedule.getGroup());
            item.setSubject(schedule.getSubject());
            item.setClassroom(schedule.getClassroom());
            scheduleRepository.save(item);
        }
    }

    public void delete(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    public List<Schedule> getScheduleForStudentSpecificDay(String firstName, String lastName, String dayName) {
        var listStudents = studentRepository.findAll();
        for (Student student : listStudents) {
            if (student.getFirstName().equalsIgnoreCase(firstName)
                    && student.getLastName().equalsIgnoreCase(lastName)) {
                return getScheduleForGroupSpecificDay(student.getGroup().getName(), dayName);
            }
        }
        return Collections.emptyList();
    }

    public List<Schedule> getScheduleForStudentAllWeek(String firstName, String lastName) {
        var listStudents = studentRepository.findAll();
        for (Student student : listStudents) {
            if (student.getFirstName().equalsIgnoreCase(firstName)
                    && student.getLastName().equalsIgnoreCase(lastName)) {
                return getScheduleForGroupAllWeek(student.getGroup().getName());
            }
        }
        return Collections.emptyList();
    }

    public List<Schedule> getScheduleForGroupSpecificDay(String groupName, String dayName) {
        var list = scheduleRepository.findAll();
        var resultList = new ArrayList<Schedule>();
        for (Schedule schedule : list) {
            if (schedule.getDay().getName().equalsIgnoreCase(dayName)
                    && schedule.getGroup().getName().equalsIgnoreCase(groupName)) {
                resultList.add(schedule);
            }
        }
        return resultList;
    }

    public List<Schedule> getScheduleForGroupAllWeek(String groupName) {
        var list = scheduleRepository.findAll();
        var resultList = new ArrayList<Schedule>();
        for (Schedule schedule : list) {
            if (schedule.getGroup().getName().equalsIgnoreCase(groupName)) {
                resultList.add(schedule);
            }
        }
        return resultList;
    }
}
