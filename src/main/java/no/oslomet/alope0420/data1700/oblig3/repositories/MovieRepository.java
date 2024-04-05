package no.oslomet.alope0420.data1700.oblig3.repositories;

import no.oslomet.alope0420.data1700.oblig3.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
