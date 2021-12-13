package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Day;
import com.mudr1k.universityschedule.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/v1/days")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping(path = "")
    public List<Day> getAllDays() {
        return dayService.findAll();
    }

    @PostMapping(path = "")
    public void create(@RequestBody Day day) {
        dayService.create(day);
    }

    @PutMapping(path = "")
    public void update(@RequestBody Day day) {
        dayService.update(day);
    }

    @DeleteMapping(path = "/{dayId}")
    public void delete(@PathVariable Long dayId) {
        dayService.delete(dayId);
    }
}
