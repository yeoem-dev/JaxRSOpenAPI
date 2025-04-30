package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Acheteur;

import java.util.List;

public class AcheteurDTO extends UtilisateurDTO {

    public AcheteurDTO() {}
    // Méthode utilitaire pour convertir une entité en DTO
    public static AcheteurDTO fromEntity(fr.istic.taa.jaxrs.concert.Acheteur acheteur) {
        if (acheteur == null) return null;

        AcheteurDTO dto = new AcheteurDTO();
        dto.setId(acheteur.getId());
        dto.setNom(acheteur.getNom());
        dto.setEmail(acheteur.getEmail());
        return dto;
    }


}
