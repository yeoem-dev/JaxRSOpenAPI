package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Billet;

import java.time.LocalDateTime;

public class BilletDTO {

    private Long id;
    private Long acheteurId;
    private Long concertId;
    private Long categorieId;
    private LocalDateTime dateAchat;

    // Libellés supplémentaires pour affichage
    private String nomConcert;
    private String libelleCategorie;

    public BilletDTO() {}

    // Getters
    public Long getId() {
        return id;
    }

    public Long getAcheteurId() {
        return acheteurId;
    }

    public Long getConcertId() {
        return concertId;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public String getNomConcert() {
        return nomConcert;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setAcheteurId(Long acheteurId) {
        this.acheteurId = acheteurId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setNomConcert(String nomConcert) {
        this.nomConcert = nomConcert;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public static BilletDTO fromEntity(Billet billet) {
        BilletDTO dto = new BilletDTO();
        dto.setId(billet.getId());
        dto.setDateAchat(billet.getDateAchat());

        if (billet.getAcheteur() != null) {
            dto.setAcheteurId(billet.getAcheteur().getId());
        }

        if (billet.getConcert() != null) {
            dto.setConcertId(billet.getConcert().getId());
            dto.setNomConcert(billet.getConcert().getNomConcert());
        }

        if (billet.getCategorie() != null) {
            dto.setCategorieId(billet.getCategorie().getId());
            dto.setLibelleCategorie(billet.getCategorie().getLibelle());
        }

        return dto;
    }
}
