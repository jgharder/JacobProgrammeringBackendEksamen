package com.example.jacobprogrammeringeksamen.repository;

import com.example.jacobprogrammeringeksamen.models.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KandidatRepository extends JpaRepository<Kandidat, Integer> {
    List<Kandidat> findKandidatsByPartiPartiNavn(String partiNavn);
    List<Kandidat> findAllKandidatsByOrderByPartiPartiNavn();
}
