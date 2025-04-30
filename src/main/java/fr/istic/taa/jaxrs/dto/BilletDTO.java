package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Billet;

import java.time.LocalDateTime;

public class BilletDTO {

    private Long id;
    private Long acheteurId;
    private Long concertId;
    private Long categorieId;
    private LocalDateTime dateAchat;

    // Constructeur vide (obligatoire pour la sérialisation JSON)
    public BilletDTO() {
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcheteurId() {
        return acheteurId;
    }

    public void setAcheteurId(Long acheteurId) {
        this.acheteurId = acheteurId;
    }

    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public static BilletDTO fromEntity(Billet billet) {
        if (billet == null) return null;

        BilletDTO dto = new BilletDTO();
        dto.setId(billet.getId());
        dto.setAcheteurId(billet.getAcheteur() != null ? billet.getAcheteur().getId() : null);
        dto.setConcertId(billet.getConcert() != null ? billet.getConcert().getId() : null);
        dto.setCategorieId(billet.getCategorie() != null ? billet.getCategorie().getId() : null);
        dto.setDateAchat(billet.getDateAchat());

        return dto;
    }


}
