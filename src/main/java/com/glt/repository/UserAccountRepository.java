package com.glt.repository;

import com.glt.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {// ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
     Optional<UserAccount> findByEmail(String email);
    //Write a derived query to read a user with a username?
    Optional<UserAccount> findByUsername(String username);
    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findAllByAccountDetails_NameContaining(String name);
    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findAllByAccountDetails_NameContainingIgnoreCase(String name);
    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount>findAllByAccountDetails_AgeGreaterThan(Integer age);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("SELECT u FROM UserAccount u where u.email = ?1")
    Optional<UserAccount>getUserByEmail(String email);
    //Write a JPQL query that returns a user read by username?
    @Query("SELECT u FROM UserAccount u where u.username =?1")
    Optional<UserAccount> getUserByUsername(String username);
    //Write a JPQL query that returns all users?
    @Query("SELECT u FROM UserAccount u ")
    List<UserAccount>getAllUser();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "SELECT * FROM user_account ua join account_details ad " +
            "On ua.account_details_id = ad.id WHERE ad.name ILIKE concat('%',?!,'%')",nativeQuery = true)
    List<UserAccount>getUserContainsName(String name);
    //Write a native query that returns all users?
    @Query(value = "SELECT * FROM user_account",nativeQuery = true)
    List<UserAccount>retrieveAllUser();
    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account ua join account_details ad " +
            "ON ua.account_details_id = ad.id WHERE ad.age BETWEEN ?1 AND ?2",nativeQuery = true)
    List<UserAccount>getAllUserAgesBetween(Integer age1, Integer age2);
    //Write a native query to read a user by email?
    @Query(value = "SELECT * FROM user_account ua WHERE ua.email =?1",nativeQuery = true)
    List<UserAccount>retrieveUserByEmail(String email);

}
