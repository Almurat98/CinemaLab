package com.glt.repository;

import com.glt.entity.Movie;
import com.glt.entity.Ticket;
import com.glt.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {// ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countTicketsByUserAccount_Id(Long id);
    //Write a derived query to list all tickets by specific email
    List<Ticket>findAllByUserAccountEmail(String email);
    //Write a derived query to count how many tickets are sold for a specific movie
    int countTicketsByMovieCinema_MovieName(String movie);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime l1,LocalDateTime l2);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t FROM Ticket t WHERE t.userAccount.id= ?1")
    List<Ticket>findByUser(Long id);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t FROM Ticket t WHERE t.dateTime between ?1 and ?2")
    List<Ticket>findBetweenDateRange(LocalDateTime l1,LocalDateTime l2);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count (*) FROM ticket WHERE ticket.user_account_id =?1 ",nativeQuery = true)
    Integer countOfTicketBoughtByUser(@Param("userId") Long id);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT count (*)FROM ticket where ticket.user_account_id =?1 and ticket.date_time between ?2 and ?3",nativeQuery = true)
    Integer countOfTicketBoughtByUserBetween(@Param("userId") Long id,@Param("dateTime") LocalDateTime ldt1,@Param("dateTime") LocalDateTime ldt2);
    //Write a native query to distinct all tickets by movie name
    @Query(value = "SELECT distinct(*) FROM ticket t join moive_cinema mc on t.movie_cinema_id = mc.id join movie m " +
            "On mc.movie_id = m.id Where m.name =?1",nativeQuery = true)
    List<Ticket>findDistinctByMovieName(@Param("movie") String name);
    //Write a native query to find all tickets by user email
    @Query(value = "SELECT * FROM ticket t join user_acount ua on t.user_account_id = ua.id where ua.email=?1",nativeQuery = true)
    List<Ticket>findByUserEmail(@Param("email") String email);
    //Write a native query that returns all tickets

    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id" +
            " JOIN account_details ad ON ua.account_detail_id =ad.id" +
            " JOIN movie_cinema mc on ad.movie_cinema_id =mc.id " +
            " JOIN movie m on mc.movie_id= m.id WHERE ua.username ILIKE concat('%',?1,'%')" +
            " Or ad.name ILIKE concat('%',?1,'%')" +
            " Or m.name ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Ticket>getBySearchCriteria(@Param("searchCriteria") String searchCriteria);

}
