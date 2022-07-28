package com.Romil.Tiwari.UserManagementApp.Service;

import com.Romil.Tiwari.UserManagementApp.DTO.User;
import com.Romil.Tiwari.UserManagementApp.DTO.UserDAO;
import org.springframework.data.domain.Page;


import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(String id);

    void addUser(User user);

    User updateUser(User user);

    User deleteUser(String id);

    UserDAO saveUser(UserDAO userDAO);

    List<UserDAO> getUserDAOByFirstName(String firstName);

    List<UserDAO> getUserDAOByLastName(String lName);

    List<UserDAO> getByNameOfUser(String fname, String lname);

    List<UserDAO> findSortedUsers(String paramForSorting);

    List<UserDAO> getUserByLastNameAndSort(String lName , String sortingParam);

    Page<UserDAO> getAllUsersByPages(int pageNumber , int numberOfElementsPerPage);

    List<UserDAO> getAllUser();

    UserDAO updateTheUser(UserDAO userDAO, Long empId);

    void deleteUserById(Long id);
}
