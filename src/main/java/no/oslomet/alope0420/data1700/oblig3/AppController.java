package no.oslomet.alope0420.data1700.oblig3;

import jakarta.validation.Valid;
import no.oslomet.alope0420.data1700.oblig3.entities.Movie;
import no.oslomet.alope0420.data1700.oblig3.entities.Ticket;
import no.oslomet.alope0420.data1700.oblig3.projections.TicketProjection;
import no.oslomet.alope0420.data1700.oblig3.repositories.MovieRepository;
import no.oslomet.alope0420.data1700.oblig3.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Validated
@RestController
public class AppController {

    @Autowired
    private TicketRepository tickets;
    @Autowired
    private MovieRepository movies;

    @GetMapping("/movies/list")
    public Collection<Movie> listMovies() {
        return movies.findAll();
    }

    @PostMapping("/tickets/add")
    public void addTickets(@Valid Ticket ticket) {
        tickets.save(ticket);
    }

    @GetMapping("/tickets/list")
    public Collection<TicketProjection> listTickets() {
        return tickets.findByOrderByLastnameAscFirstnameAsc();
    }

    @PostMapping("/tickets/clear")
    public void clearTickets() {
        tickets.deleteAll();
    }
}
