package com.Romil.Tiwari.UserManagementApp.Controller;

import com.Romil.Tiwari.UserManagementApp.DTO.UserDAO;
import com.Romil.Tiwari.UserManagementApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserControllerDAO {

    @Autowired
    private UserService userService;

    @PostMapping("/saving")
    public ResponseEntity<Object> addUser(@RequestBody UserDAO userDAO) {
        userService.saveUser(userDAO);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(userDAO.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
//  //  public UserDAO saveUser(@RequestBody UserDAO userDAO){
//        return userService.saveUser(userDAO);

    @GetMapping("/allUsers")
    public List<UserDAO> getAllUser(){
        return userService.getAllUser();
    }

    @PutMapping("/updateUser/{id}")
    public UserDAO updateTheUser(@RequestBody UserDAO userDAO,
                                 @PathVariable("id") Long empId){
        return userService.updateTheUser(userDAO , empId);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Long id){
         userService.deleteUserById(id);
    }

    @GetMapping("/byName/{firstName}")
    public List<UserDAO> getUserDAOByFirstName(@PathVariable("firstName") String firstName){
        return userService.getUserDAOByFirstName(firstName);
    }
    // Query
    @GetMapping("/byname/{lName}")
    public List<UserDAO> getUserDAOByLastName(@PathVariable("lName") String lName){
        return userService.getUserDAOByLastName(lName);
    }
    // Query
    @GetMapping("/name/{fname}/{lname}")
    public List<UserDAO>getByNameOfUser(@PathVariable("fname") String fname ,
                                        @PathVariable("lname") String lname){
        return userService.getByNameOfUser(fname,lname);
    }

    // Sorting
    @GetMapping("/getAllSortedUsers/{sortedParam}")
    public List<UserDAO>getAllSortedUsers(@PathVariable String sortedParam){
        return userService.findSortedUsers(sortedParam);
    }
    // Get User By LastName and then Sort it by given field
    @GetMapping("/getUserByLastNameAndSort/{lastName}/{sortingParam}")
    public List<UserDAO> getUserByLastNameAndSort(@PathVariable String lastName,
                                                  @PathVariable String sortingParam){
        return userService.getUserByLastNameAndSort(lastName, sortingParam);
    }

    // Paging (Page start from 0 to N-1)
    @GetMapping("/getAllUsersByPages/{pageNumber}/{numberOfElementsPerPage}")
    public Page<UserDAO> getAllUsersByPages(@PathVariable int pageNumber,
                                            @PathVariable int numberOfElementsPerPage){
        return userService.getAllUsersByPages(pageNumber,numberOfElementsPerPage);
    }
}
