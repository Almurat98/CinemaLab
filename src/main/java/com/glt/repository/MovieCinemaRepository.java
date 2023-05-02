package com.glt.repository;

import com.glt.entity.Location;
import com.glt.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> { // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
   Optional<MovieCinema> findById(Long id);
    //Write a derived query to count all movie cinemas with a specific cinema id
    List<MovieCinema>findByCinemaId(Long id);
    //Write a derived query to count all movie cinemas with a specific movie id
    List<MovieCinema>findAllByMovieId(Long id);
    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema>findAllByDateTimeAfter(LocalDateTime dateTime);
    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema>findTop3ByMoviePriceOrderByMoviePriceDesc();
    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema>findAllByMovieNameContaining(String name);
    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema>findAllByCinemaLocation(Location location);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT mc FROM MovieCinema mc WHERE mc.dateTime > ?1")
    List<MovieCinema>findAllByDateTimeLater(LocalDateTime dateTime);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT count (MovieCinema ) FROM MovieCinema where cinema.id=?1",nativeQuery = true)
     Integer movieCinemaCountByCinemaId(@Param("id") Long id);
    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT * FROM MovieCinema where Location.name = ?1",nativeQuery = true)
    List<MovieCinema>findByLocationName(@Param("name") String name);

}
