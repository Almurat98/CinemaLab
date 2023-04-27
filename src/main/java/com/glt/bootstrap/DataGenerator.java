package com.glt.bootstrap;

import com.glt.entity.Ticket;
import com.glt.enums.Role;
import com.glt.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DataGenerator implements CommandLineRunner {
        private AccountDetailRepository accountDetailRepository;
        private CinemaRepository cinemaRepository;
        private GenreRepository genreRepository;
        private LocationRepository locationRepository;
        private MovieRepository movieRepository;
        private TicketRepository ticketRepository;
        private UserAccountRepository userAccountRepository;

    public DataGenerator(AccountDetailRepository accountDetailRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, LocationRepository locationRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserAccountRepository userAccountRepository) {
        this.accountDetailRepository = accountDetailRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.locationRepository = locationRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        accountDetailRepository.findByCountryOrState("United States","Texas").forEach(System.out::println);
        accountDetailRepository.findByAgeLessThanEqual(45).forEach(System.out::println);
        accountDetailRepository.findByRole(Role.MANAGER).forEach(System.out::println);
        accountDetailRepository.findByAgeBetween(22,35).forEach(System.out::println);
        accountDetailRepository.findByAddressStartingWith("T").forEach(System.out::println);
        accountDetailRepository.findAllByOrderByAge().forEach(System.out::println);
    }
}
