package fr.istic.taa.jaxrs.concert;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomConcert;
    private String lieu;
    private Date date;

    @ManyToOne
    private Organisateur organisateur;
    public Concert() {
        super();
    }

    public Concert(String nomConcert, String lieu, Date date, Organisateur organisateur) {

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

    public void setNomConcert(String nomConcert) {
        this.nomConcert = nomConcert;
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