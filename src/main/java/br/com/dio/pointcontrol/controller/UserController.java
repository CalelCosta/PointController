package br.com.dio.pointcontrol.controller;

import br.com.dio.pointcontrol.model.AnnualLeave;
import br.com.dio.pointcontrol.model.User;
import br.com.dio.pointcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public List<User> getUserList(){
        return userService.findAll();
    }

    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable("idUser") Long idUser) throws Exception {
        return userService.findById(idUser).orElseThrow(() -> new NoSuchElementException("Not found!"));
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity deleteByID(@PathVariable("idUser") Long idUser) throws Exception {
        try {
            userService.deleteUser(idUser);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<AnnualLeave>) ResponseEntity.ok();
    }
}
