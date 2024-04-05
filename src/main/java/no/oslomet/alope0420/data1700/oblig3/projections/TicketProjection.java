package no.oslomet.alope0420.data1700.oblig3.projections;

import org.springframework.beans.factory.annotation.Value;

public interface TicketProjection {
    @Value("#{target.movie.name}")
    String getMovie();

    Integer getCount();
    String getFirstname();
    String getLastname();
    String getTel();
    String getEmail();
}
