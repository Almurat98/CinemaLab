package com.glt.repository;

import com.glt.entity.AccountDetails;
import com.glt.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDetailRepository extends JpaRepository<AccountDetails,Long> {
    //Write a derived query to list all accounts with a specific country or state
    List<AccountDetails>findByCountryOrState(String country,String state);
    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails>findByAgeLessThanEqual(int age);
    //Write a derived query to list all accounts with a specific role
    List<AccountDetails>findByRole(Role role);
    //Write a derived query to list all accounts between a range of ages
    List<AccountDetails>findByAgeBetween(int age1,int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails>findByAddressStartingWith(String keyword);
    //Write a derived query to sort the list of accounts with age
    List<AccountDetails> findAllByOrderByAge();
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT a FROM AccountDetails a")
    List<AccountDetails>findAllAccount();
    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM AccountDetails  a WHERE a.role= 'admin'")
    List<AccountDetails>findAccountByRole();
    //Write a JPQL query to sort all accounts with age
    @Query("select a FROM AccountDetails  a order by a.age")
    List<AccountDetails>sortByAge();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city

    //Write a native query to read all accounts with an age lower than a specific value

}
