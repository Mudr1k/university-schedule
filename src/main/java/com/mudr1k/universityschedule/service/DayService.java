package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Day;
import com.mudr1k.universityschedule.repository.DayRepository;
import com.mudr1k.universityschedule.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {

    private final DayRepository dayRepository;

    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    public List<Day> findAll() {
        return dayRepository.findAll();
    }

    public void create(Day day) {
        if (dayRepository.findDayByName(day.getName()).isPresent()) {
            throw new RestApiException("The day '" + day.getName() + "' already exists");
        }
        dayRepository.save(day);
    }

    public void update(Day day) {
        var row = dayRepository.findById(day.getId());
        if (row.isPresent()) {
            var item = row.get();
            if (!day.getName().isEmpty()) {
                item.setName(day.getName());
            }
            dayRepository.save(item);
        }
    }

    public void delete(Long dayId) {
        dayRepository.deleteById(dayId);
    }
}
