package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Schedule;
import com.mudr1k.universityschedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/v1/")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(path = "schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    @PostMapping(path = "schedules")
    public void create(@RequestBody Schedule schedule) {
        scheduleService.create(schedule);
    }

    @PutMapping(path = "schedules")
    public void update(@RequestBody Schedule schedule) {
        scheduleService.update(schedule);
    }

    @DeleteMapping(path = "schedules/{scheduleId}")
    public void delete(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
    }

    @GetMapping(path = "students/{firstName}.{lastName}/schedule/{dayName}")
    public List<Schedule> getScheduleForStudentSpecificDay(@PathVariable String firstName,
                                                           @PathVariable String lastName,
                                                           @PathVariable String dayName) {
        return scheduleService.getScheduleForStudentSpecificDay(firstName, lastName, dayName);
    }

    @GetMapping(path = "students/{firstName}.{lastName}/schedule/")
    public List<Schedule> getScheduleForStudentAllWeek(@PathVariable String firstName,
                                                       @PathVariable String lastName) {
        return scheduleService.getScheduleForStudentAllWeek(firstName, lastName);
    }

    @GetMapping(path = "groups/{groupName}/schedule/{dayName}")
    public List<Schedule> getScheduleForGroupSpecificDay(@PathVariable String groupName,
                                                         @PathVariable String dayName) {
        return scheduleService.getScheduleForGroupSpecificDay(groupName, dayName);
    }


}
