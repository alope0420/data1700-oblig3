package no.oslomet.alope0420.data1700.oblig3;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class AppController {

    @Autowired
    TicketRepository repo;

    @PostMapping("/tickets/add")
    public void addTickets(@Valid Ticket ticket) {
        repo.addTickets(ticket);
    }

    @GetMapping("/tickets/list")
    public List<Ticket> listTickets() {
        return repo.listTickets();
    }

    @PostMapping("/tickets/clear")
    public void clearTickets() {
        repo.clearTickets();
    }
}
