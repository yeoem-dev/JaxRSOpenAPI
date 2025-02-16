package fr.istic.taa.jaxrs.concert;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Organisateur extends Utilisateur {
    @OneToMany(mappedBy = "organisateur", cascade = CascadeType.PERSIST)
    private List<Concert> concerts = new ArrayList<>();

    public Organisateur(String nom, String email) {
        super(nom, email);
    }

    public Organisateur() {
        super();
    }

    public void ajouterConcert(Concert concert) {
       concerts.add(concert);
       concert.setOrganisateur(this);
    }

    // Getters et setters

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
}