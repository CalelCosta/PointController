package br.com.dio.pointcontrol.controller;


import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.Occurrence;
import br.com.dio.pointcontrol.service.OccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceController {

    @Autowired
    OccurrenceService occurrenceService;

    @PostMapping
    public Occurrence createOccurrence(@RequestBody Occurrence occurrence) {
        return occurrenceService.save(occurrence);
    }

    @GetMapping
    public List<Occurrence> getOccurrenceList(){
        return occurrenceService.findAll();
    }

    @GetMapping("/{idOccurrence}")
    public Occurrence getOccurrenceById(@PathVariable("idOccurrence") Long idOccurrence) throws Exception {
        return occurrenceService.findById(idOccurrence).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public Occurrence updateOccurrence(@RequestBody Occurrence occurrence){
        return occurrenceService.updateOccurrence(occurrence);
    }

    @DeleteMapping("/{idOccurrence}")
    public ResponseEntity deleteByID(@PathVariable("idOccurrence") Long idOccurrence) throws Exception {
        try {
            occurrenceService.deleteOccurrence(idOccurrence);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
