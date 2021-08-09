package br.com.dio.pointcontrol.controller;


import br.com.dio.pointcontrol.model.AccessLevel;
import br.com.dio.pointcontrol.model.WorkingDay;
import br.com.dio.pointcontrol.service.AccessLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessLevel")
public class AccessLevelController {

    @Autowired
    AccessLevelService accessLevelService;

    @PostMapping
    public AccessLevel createAccess(@RequestBody AccessLevel accessLevel){
        return accessLevelService.saveAccess(accessLevel);
    }

    @GetMapping
    public List<AccessLevel> getAccess(){
        return accessLevelService.findAll();
    }

    @GetMapping("{/idAccessLevel}")
    public AccessLevel getAccessById(@PathVariable("idAccessLevel") Long idAccessLevel) throws Exception {
        return accessLevelService.findById(idAccessLevel).orElseThrow(() -> new Exception("Not Found!"));
    }

    @PutMapping
    public AccessLevel updateAccess(@RequestBody AccessLevel accessLevel){
        return accessLevelService.updateAccess(accessLevel);
    }

    @DeleteMapping("/{idAccessLevel}")
    public ResponseEntity deleteAccess(@PathVariable("idAccessLevel") Long idAccessLevel) throws Exception {
        try {
            accessLevelService.deleteAccess(idAccessLevel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<WorkingDay>) ResponseEntity.ok();
    }
}
