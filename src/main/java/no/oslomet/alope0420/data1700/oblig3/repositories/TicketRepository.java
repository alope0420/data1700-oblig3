package no.oslomet.alope0420.data1700.oblig3.repositories;

import no.oslomet.alope0420.data1700.oblig3.entities.Ticket;
import no.oslomet.alope0420.data1700.oblig3.projections.TicketProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    <T extends TicketProjection> Collection<T> findByOrderByLastnameAscFirstnameAsc();
}
