package com.example.jacobprogrammeringeksamen.RESTController;

import com.example.jacobprogrammeringeksamen.models.Kandidat;
import com.example.jacobprogrammeringeksamen.repository.KandidatRepository;
import com.example.jacobprogrammeringeksamen.repository.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class KandidatRESTController {

    @Autowired
    KandidatRepository kandidatRepository;

    @GetMapping("/kandidater")
    public List<Kandidat> fåAlleKandidater(){
        return kandidatRepository.findAll();
    }
    @GetMapping("/kandidater/sorteret")
    public List<Kandidat> fåSorteretKandidater(){
        return kandidatRepository.findAllKandidatsByOrderByPartiPartiNavn();
    }
    @GetMapping("/kandidater/{parti}")
    public List<Kandidat> findKandidatMedParti(@PathVariable String parti){
        return kandidatRepository.findKandidatsByPartiPartiNavn(parti);
    }

    @PostMapping(value="/kandidat", consumes = "application/json")
    public ResponseEntity<Kandidat> tilføjKandidat(@RequestBody Kandidat kandidat){
        kandidatRepository.save(kandidat);
        return new ResponseEntity<Kandidat>(kandidat, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/kandidat/{id}")
    public ResponseEntity<Kandidat> sletKandidat(@PathVariable int id){
        kandidatRepository.deleteById(id);
        return new ResponseEntity<Kandidat>(HttpStatus.OK);
    }

    @PutMapping(value="/kandidat/opdater",consumes = "application/json")
    public ResponseEntity<Kandidat> opdaterKandidat(@RequestBody Kandidat kandidat){
        Optional<Kandidat> kandidatData = kandidatRepository.findById(kandidat.getKandidatId());
        if(kandidatData.isPresent()){
            Kandidat opdateretKandidat = kandidatData.get();
            opdateretKandidat.setKandidatNavn(kandidat.getKandidatNavn());
            opdateretKandidat.setStemmetal(kandidat.getStemmetal());
            opdateretKandidat.setParti(kandidat.getParti());
            kandidatRepository.save(opdateretKandidat);
        }
        return new ResponseEntity<>(kandidat, HttpStatus.OK);
    }
}


