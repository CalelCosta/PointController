package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.UserCategory;
import br.com.dio.pointcontrol.service.UsercategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/userCategory")
public class UserCategoryController {

    @Autowired
    UsercategoryService usercategoryService;

    @PostMapping
    public UserCategory createUserCategory(@RequestBody UserCategory userCategory) {
        return usercategoryService.save(userCategory);
    }

    @GetMapping
    public List<UserCategory> getUserCategoryList(){
        return usercategoryService.findAll();
    }

    @GetMapping("/{idUserCategory}")
    public UserCategory getUserCategoryById(@PathVariable("idUserCategory") Long idUserCategory) throws Exception {
        return usercategoryService.findById(idUserCategory).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public UserCategory updateOccurrence(@RequestBody UserCategory userCategory){
        return usercategoryService.updateUserCategory(userCategory);
    }

    @DeleteMapping("/{idUserCategory}")
    public ResponseEntity deleteByID(@PathVariable("idUserCategory") Long idUserCategory) throws Exception {
        try {
            usercategoryService.deleteUserCategory(idUserCategory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
