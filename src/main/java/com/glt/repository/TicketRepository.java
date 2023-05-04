package com.glt.repository;

import com.glt.entity.Movie;
import com.glt.entity.Ticket;
import com.glt.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {// ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countTicketsByUserAccount_Id(Long id);
    //Write a derived query to list all tickets by specific email
    List<Ticket>findAllByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    int countTicketsByMovieCinema_Movie(Movie movie);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime l1,LocalDateTime l2);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount= ?1")
    List<Ticket>findByUser(UserAccount userAccount);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime between ?1 and ?2")
    List<Ticket>findBetweenDateRange(LocalDateTime l1,LocalDateTime l2);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    //Write a native query to count the number of tickets a user bought in a specific range of dates

    //Write a native query to distinct all tickets by movie name

    //Write a native query to find all tickets by user email

    //Write a native query that returns all tickets

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

}
