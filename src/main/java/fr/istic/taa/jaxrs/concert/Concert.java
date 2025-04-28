package fr.istic.taa.jaxrs.concert;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Concert implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String lieu;
    private Date date;

    @ManyToOne
    @JoinColumn(name="organisateur_id")
    private Organisateur organisateur;
    public Concert() {
        super();
    }

    public Concert(String nom, String lieu, Date date, Organisateur organisateur) {

        this.nom = nom;
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
        return nom;
    }

    public void setNomConcert(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

}