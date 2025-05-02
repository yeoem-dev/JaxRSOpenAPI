package fr.istic.taa.jaxrs.dto;

import java.time.LocalDateTime;

public class ConcertDTO {

    private Long id;
    private String nomConcert;
    private String lieu;
    private LocalDateTime date;
    private Long organisateurId;

    public ConcertDTO() {
    }

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(Long organisateurId) {
        this.organisateurId = organisateurId;
    }

    public static ConcertDTO fromEntity(fr.istic.taa.jaxrs.concert.Concert concert) {
        if (concert == null) return null;

        ConcertDTO dto = new ConcertDTO();
        dto.setId(concert.getId());
        dto.setNomConcert(concert.getNomConcert());
        dto.setLieu(concert.getLieu());
        dto.setDate(concert.getDate()); // LocalDateTime
        dto.setOrganisateurId(
                concert.getOrganisateur() != null ? concert.getOrganisateur().getId() : null
        );
        return dto;
    }
}
