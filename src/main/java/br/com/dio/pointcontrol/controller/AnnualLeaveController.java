package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.service.AnnualLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/annualLeave")
public class AnnualLeaveController {

        @Autowired
        AnnualLeaveService annualLeaveService;

        @PostMapping
        public AnnualLeave createAnnualLeave(@RequestBody AnnualLeave annualLeave) {
            return annualLeaveService.save(annualLeave);
        }

        @GetMapping
        public List<AnnualLeave> getAnnualLeaveList(){
            return annualLeaveService.findAll();
        }

        @GetMapping("/{idAnnualLeave}")
        public AnnualLeave getAnnualLeaveById(@PathVariable("idAnnualLeave") Long idAnnualLeave) throws Exception {
            return annualLeaveService.findById(idAnnualLeave).orElseThrow(() -> new NoSuchElementException("Not found!"));
        }

        @PutMapping
        public AnnualLeave updateAnnualLeave(@RequestBody AnnualLeave annualLeave){
            return annualLeaveService.updateAnnualLeave(annualLeave);
        }

        @DeleteMapping("/{idAnnualLeave}")
        public ResponseEntity deleteByID(@PathVariable("idAnnualLeave") Long idAnnualLeave) throws Exception {
            try {
                annualLeaveService.deleteAnnualLeave(idAnnualLeave);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
        }
    }
