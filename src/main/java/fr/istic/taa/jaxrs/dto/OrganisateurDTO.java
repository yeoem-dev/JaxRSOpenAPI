package fr.istic.taa.jaxrs.dto;


import fr.istic.taa.jaxrs.concert.Organisateur;

public class OrganisateurDTO extends UtilisateurDTO {

    // Méthode utilitaire pour convertir une entité en DTO
    public static OrganisateurDTO fromEntity(Organisateur organisateur) {
        if ( organisateur == null) return null;

        OrganisateurDTO dto = new OrganisateurDTO();
        dto.setId(organisateur.getId());
        dto.setNom(organisateur.getNom());
        dto.setEmail(organisateur.getEmail());
        return dto;
    }
}
