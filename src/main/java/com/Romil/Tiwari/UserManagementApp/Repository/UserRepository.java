package com.Romil.Tiwari.UserManagementApp.Repository;

import com.Romil.Tiwari.UserManagementApp.DTO.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository  {

    List<User> userList = new ArrayList<>();


    public List<User> getAllUsers(){
        return userList;
    }

    public User getUser(String id) {

        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if(first.isPresent()){
            return first.get();
        }
        else{
            return new User(); // need to add exception
        }
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User updateUser(User user) {
        for( User u : userList){
            if(u.getId().equals(user.getId())){
                u.setName(user.getName());
                u.setAddress(user.getAddress());
                return u;
            }
        }
        return new User(); // need to add Exception
    }

    public User deleteUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if(first.isPresent()){
            User user = first.get();
            userList.remove(user);
            return user;
        }
        else{
            return new User(); // need to add exception
        }
    }
}
