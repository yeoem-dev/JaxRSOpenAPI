package fr.istic.taa.jaxrs.concert;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Concert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomConcert;
    private String lieu;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="organisateur_id")
    private Organisateur organisateur;
    public Concert() {
        super();
    }

    public Concert(String nomConcert, String lieu, LocalDateTime date, Organisateur organisateur) {

        this.nomConcert = nomConcert;
        this.lieu = lieu;
        this.date = date;
        this.organisateur = organisateur;
    }


    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomConcert() {
        return nomConcert;
    }

    public void setNomConcert(String nom) {
        this.nomConcert = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

}