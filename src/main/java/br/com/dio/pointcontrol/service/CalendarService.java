package br.com.dio.pointcontrol.service;


import br.com.dio.pointcontrol.model.Calendar;
import br.com.dio.pointcontrol.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar save(Calendar calendar) {
        return this.calendarRepository.save(calendar);
    }

    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Optional<Calendar> findById(Long idCalendar) {
        return calendarRepository.findById(idCalendar);
    }

    public Calendar updateCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public void deleteCalendar(Long idCalendar) {
        calendarRepository.deleteById(idCalendar);
    }
}
