package com.Romil.Tiwari.UserManagementApp.Service;

import com.Romil.Tiwari.UserManagementApp.DTO.User;
import com.Romil.Tiwari.UserManagementApp.DTO.UserDAO;
import com.Romil.Tiwari.UserManagementApp.Repository.UserRepository;
import com.Romil.Tiwari.UserManagementApp.Repository.UserRepositoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryDAO userRepositoryDAO;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(String id) {
        return userRepository.getUser(id);
    }

    @Override
    public void addUser(User user) {
     userRepository.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public User deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public UserDAO saveUser(UserDAO userDAO) {
        return userRepositoryDAO.save(userDAO);
    }

    @Override
    public List<UserDAO> getUserDAOByFirstName(String firstName) {
        return userRepositoryDAO.getUserDAOByFirstName(firstName);
    }

    @Override
    public List<UserDAO> getUserDAOByLastName(String lName) {
        return userRepositoryDAO.getUserDAOByLastName(lName);
    }

    @Override
    public List<UserDAO> getByNameOfUser(String fname, String lname) {
        return userRepositoryDAO.getByNameOfUser(fname,lname);
    }

    @Override
    public List<UserDAO> findSortedUsers(String paramForSorting) {
        return userRepositoryDAO.findAll(Sort.by(paramForSorting));
    }

    @Override
    public List<UserDAO> getUserByLastNameAndSort(String lName, String sortingParam) {
        return userRepositoryDAO.getUserByLastNameAndSort(lName , Sort.by(sortingParam));
    }

    @Override
    public Page<UserDAO> getAllUsersByPages(int pageNumber, int numberOfElementsPerPage) {
        return userRepositoryDAO.findAll(PageRequest.of(pageNumber,numberOfElementsPerPage));
    }

    @Override
    public List<UserDAO> getAllUser() {
        return userRepositoryDAO.findAll();
    }

    @Override
    public UserDAO updateTheUser(UserDAO userDAO, Long empId) {
        UserDAO dao = userRepositoryDAO.findById(empId).get();
            dao.setFirstName(userDAO.getFirstName());
            dao.setLastName(userDAO.getLastName());
            dao.setAddress(userDAO.getAddress());
            userRepositoryDAO.save(dao);

        return dao;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepositoryDAO.deleteById(id);
    }
}
