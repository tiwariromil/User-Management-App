package com.Romil.Tiwari.UserManagementApp.Controller;

import com.Romil.Tiwari.UserManagementApp.DTO.User;
import com.Romil.Tiwari.UserManagementApp.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.addUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(String id) {
        return userService.deleteUser(id);
    }
    // by default trace and debug are disabled to enable these use
   /* @GetMapping("/logs")
    public void logdetails(){
        log.trace("trace");
        log.debug("Debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }*/
}
