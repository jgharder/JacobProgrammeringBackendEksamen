package com.example.jacobprogrammeringeksamen.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString

@Entity
public class Parti {
    @Id
    @GeneratedValue
    private int partiId;
    private String partiNavn;
    private String partiBogstav;
    private int stemmetal;
    private double procent;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="partiId")
    @JsonBackReference
    private Set<Kandidat> kandidatList = new HashSet<>();

}
