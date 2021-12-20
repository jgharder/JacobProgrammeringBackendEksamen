package com.example.jacobprogrammeringeksamen.RESTController;


import com.example.jacobprogrammeringeksamen.models.Kandidat;
import com.example.jacobprogrammeringeksamen.models.Parti;
import com.example.jacobprogrammeringeksamen.repository.PartiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PartiRESTController {

    @Autowired
    PartiRepository partiRepository;
}
