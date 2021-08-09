package br.com.dio.pointcontrol.controller;


import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.Movement;
import br.com.dio.pointcontrol.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    MovementService movementService;

    @PostMapping
    public Movement createMovement(@RequestBody Movement movement) {
        return movementService.save(movement);
    }

    @GetMapping
    public List<Movement> getMovementList(){
        return movementService.findAll();
    }

    @GetMapping("/{idMovement}")
    public Movement getMovementById(@PathVariable("idMovement") Long idMovement) throws Exception {
        return movementService.findById(idMovement).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public Movement updateMovement(@RequestBody Movement movement){
        return movementService.updateMovement(movement);
    }

    @DeleteMapping("/{idMovement}")
    public ResponseEntity deleteByID(@PathVariable("idMovement") Long idMovement) throws Exception {
        try {
            movementService.deleteMovement(idMovement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
