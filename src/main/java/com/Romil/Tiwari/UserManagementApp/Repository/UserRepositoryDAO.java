package com.Romil.Tiwari.UserManagementApp.Repository;

import com.Romil.Tiwari.UserManagementApp.DTO.UserDAO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepositoryDAO extends JpaRepository<UserDAO , Long> {
    
    @Query("select u from UserDAO u where u.firstName = ?1")
    List<UserDAO> getUserDAOByFirstName(@Param("firstName") String firstName111);

    @Query("select u from UserDAO u where u.lastName = :lastName")
    List<UserDAO> getUserDAOByLastName(@Param("lastName") String lName);

    @Query("select u from UserDAO u where u.lastName= ?2 and u.firstName= ?1")
    List<UserDAO> getByNameOfUser(String fname , String lname);

    // Custom Sorting
    @Query("select u from UserDAO u where lastName =:lastName")
    List<UserDAO> getUserByLastNameAndSort(@Param("lastName") String lName, Sort sort);
}
