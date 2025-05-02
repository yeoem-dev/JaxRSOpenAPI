package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Acheteur;

import java.util.List;
import java.util.stream.Collectors;

public class AcheteurDetailsDTO {

    private Long id;
    private String nom;
    private String email;
    private List<BilletDTO> billets;

    public AcheteurDetailsDTO() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public List<BilletDTO> getBillets() {
        return billets;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBillets(List<BilletDTO> billets) {
        this.billets = billets;
    }

    public static AcheteurDetailsDTO fromEntity(Acheteur acheteur) {
        AcheteurDetailsDTO dto = new AcheteurDetailsDTO();
        dto.setId(acheteur.getId());
        dto.setNom(acheteur.getNom());
        dto.setEmail(acheteur.getEmail());

        if (acheteur.getBillets() != null) {
            dto.setBillets(
                    acheteur.getBillets().stream()
                            .map(BilletDTO::fromEntity)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
