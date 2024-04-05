package no.oslomet.alope0420.data1700.oblig3;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import no.oslomet.alope0420.data1700.oblig3.entities.Movie;
import no.oslomet.alope0420.data1700.oblig3.entities.Ticket;
import no.oslomet.alope0420.data1700.oblig3.repositories.MovieRepository;
import no.oslomet.alope0420.data1700.oblig3.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
public class AppController {

    @Autowired
    private TicketRepository tickets;
    @Autowired
    private MovieRepository movies;

    @PostConstruct
    public void initialize() {
        movies.save(new Movie(null, "The Godfather"));
        movies.save(new Movie(null, "The Dark Knight"));
        movies.save(new Movie(null, "Pulp Fiction"));
        movies.save(new Movie(null, "Fight Club"));
        movies.save(new Movie(null, "Forrest Gump"));
        movies.save(new Movie(null, "Inception"));
    }

    @GetMapping("/movies/list")
    public List<Movie> listMovies() {
        return movies.findAll();
    }

    @PostMapping("/tickets/add")
    public void addTickets(@Valid Ticket ticket) {
        tickets.save(ticket);
    }

    @GetMapping("/tickets/list")
    public List<Ticket> listTickets() {
        return tickets.findAll(Sort.by("lastname", "firstname"));
    }

    @PostMapping("/tickets/clear")
    public void clearTickets() {
        tickets.deleteAll();
    }
}
