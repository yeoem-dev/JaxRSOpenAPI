package fr.istic.taa.jaxrs.concert;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Acheteur extends Utilisateur {
    @OneToMany(mappedBy = "acheteur", cascade = CascadeType.PERSIST)
    private List<Billet> billets = new ArrayList<>();

    public void acheterBillet(Concert concert, Categorie categorie) {
        Billet billet = new Billet(this, concert, categorie);
        billets.add(billet);
    }

    public Acheteur(String nom, String email) {
        super(nom, email);
    }
    public Acheteur() {}

    // Getters et setters

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }
}

