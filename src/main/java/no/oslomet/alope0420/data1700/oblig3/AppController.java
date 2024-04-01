package no.oslomet.alope0420.data1700.oblig3;

import jakarta.validation.Valid;
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
    private TicketRepository repo;

    @PostMapping("/tickets/add")
    public void addTickets(@Valid Ticket ticket) {
        repo.save(ticket);
    }

    @GetMapping("/tickets/list")
    public List<Ticket> listTickets() {
        return repo.findAll(Sort.by("lastname", "firstname"));
    }

    @PostMapping("/tickets/clear")
    public void clearTickets() {
        repo.deleteAll();
    }
}
