package br.com.dio.pointcontrol.controller;


import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.Calendar;
import br.com.dio.pointcontrol.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @PostMapping
    public Calendar createCalendar(@RequestBody Calendar calendar) {
        return calendarService.save(calendar);
    }

    @GetMapping
    public List<Calendar> getCalendarList(){
        return calendarService.findAll();
    }

    @GetMapping("/{idCalendar}")
    public Calendar getCalendarById(@PathVariable("idCalendar") Long idCalendar) throws Exception {
        return calendarService.findById(idCalendar).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public Calendar updateCalendar(@RequestBody Calendar calendar){
        return calendarService.updateCalendar(calendar);
    }

    @DeleteMapping("/{idCalendar}")
    public ResponseEntity deleteByID(@PathVariable("idCalendar") Long idCalendar) throws Exception {
        try {
            calendarService.deleteCalendar(idCalendar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
