package com.glt.repository;

import com.glt.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {  // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name

   Optional<Cinema> findByName(String name);
    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema>findTop3BySponsoredNameContainingOrderBySponsoredNameDesc(String partialName);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema>findAllByLocation_Country(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema>findByNameOrSponsoredName(String name,String sponsoredName);
    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    @Query("SELECT c.name FROM Cinema c where c.id =?1")
    String getNameWithId(Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT Location.country FROM Cinema where Location.country =?1",nativeQuery = true)
    List<Cinema>findByCountry(String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM Cinema WHERE name contains ?1 or sponsoredName contains ?1 ",nativeQuery = true)
    List<Cinema>findAllByNameOrSponsoredNameContaining(@Param("pattern") String pattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM Cinema ORDER BY name",nativeQuery = true)
    List<Cinema>sortByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct (*) FROM Cinema group by sponsoredName",nativeQuery = true)
    List<Cinema>findDistinctBySponsoredName();

}
