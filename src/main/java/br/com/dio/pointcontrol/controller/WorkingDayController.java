package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.WorkingDay;
import br.com.dio.pointcontrol.service.WorkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/working")
public class WorkingDayController {

    @Autowired
    WorkingService workingService;

    @PostMapping
    public WorkingDay createWorkingDay(@RequestBody WorkingDay workingDay){
        return workingService.saveWork(workingDay);
    }

    @GetMapping
    public List<WorkingDay> getWorkList(){
        return workingService.findAll();
    }

    @GetMapping("{/idWorking}")
    public WorkingDay getWorkById(@PathVariable("idWorking") Long idWorking) throws Exception {
        return workingService.findById(idWorking).orElseThrow(() -> new Exception("Not Found!"));
    }

    @PutMapping
    public WorkingDay updateWorkingDay(@RequestBody WorkingDay workingDay){
        return workingService.updateWorkingDay(workingDay);
    }

    @DeleteMapping("/{idWorking}")
    public ResponseEntity deleteWorkingDay(@PathVariable("idWorking") Long idWorking) throws Exception {
        try {
            workingService.deleteWorkingDay(idWorking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkingDay>) ResponseEntity.ok();
    }
}
