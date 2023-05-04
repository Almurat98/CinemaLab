package com.glt.repository;

import com.glt.entity.Movie;
import com.glt.enums.State;
import com.glt.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
        Optional <Movie> findByName(String name);
    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal price1,BigDecimal price2);
    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie>findAllByDurationExists(Integer duration, List<Integer>durations);
    //Write a derived query to list all movies with higher than a specific release date
    List<Movie>findAllByReleaseDateAfter(LocalDateTime releaseDate);
    //Write a derived query to list all movies with a specific state and type
    List<Movie>findAllByStateAndType(State state, Type type);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m where m.price between ?1 and ?2")
    List<Movie>findAllByPriceBetweenRange(BigDecimal p1,BigDecimal p2);
    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m ")
    List<String>getAllMovieName();
    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM movie where name = ?1",nativeQuery = true)
    Movie findMovieByName(@Param("name") String name);
    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie where price between ?1 and ?2",nativeQuery = true)
    List<Movie>findAllBetween(@Param("price") BigDecimal p1,@Param("price")BigDecimal p2);
    //Write a native query to return all movies where duration exists in the range of duration

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT *FROM movie order by price desc  limit 5",nativeQuery = true)
    List<Movie>get5MostExpensive();
}
