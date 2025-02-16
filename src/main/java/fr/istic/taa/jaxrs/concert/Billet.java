package fr.istic.taa.jaxrs.concert;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Acheteur acheteur;

    @ManyToOne(optional = false)
    private Concert concert;

    @ManyToOne(optional = false)
    private Categorie categorie;

    private LocalDateTime dateAchat;



    public Billet(Acheteur acheteur, Concert concert, Categorie categorie) {
        this.acheteur = acheteur;
        this.concert = concert;
        this.categorie = categorie;
        this.dateAchat = LocalDateTime.now();
    }

    public Billet() {
        super();
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acheteur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Acheteur acheteur) {
        this.acheteur = acheteur;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}