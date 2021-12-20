package com.example.jacobprogrammeringeksamen.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class Kandidat {
    @Id
    @GeneratedValue
    private int kandidatId;
    private String kandidatNavn;
    private int stemmetal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partiId")
    private Parti parti;
}