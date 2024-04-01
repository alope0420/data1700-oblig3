package no.oslomet.alope0420.data1700.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate db;

    public void addTickets(Ticket ticket) {
        db.update("insert into tickets values (?, ?, ?, ?, ?, ?)",
                ticket.getMovie(),
                ticket.getCount(),
                ticket.getFirstname(),
                ticket.getLastname(),
                ticket.getTel(),
                ticket.getEmail()
                );
    }

    public List<Ticket> listTickets() {
        return db.query("select * from tickets",
                new BeanPropertyRowMapper<Ticket>(Ticket.class));
    }

    public void clearTickets() {
        db.update("delete from tickets");
    }
}
