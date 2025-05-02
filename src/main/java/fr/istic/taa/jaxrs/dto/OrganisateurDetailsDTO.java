package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Organisateur;

import java.util.List;
import java.util.stream.Collectors;

public class OrganisateurDetailsDTO {

    private Long id;
    private String nom;
    private String email;
    private List<ConcertDTO> concerts;

    public OrganisateurDetailsDTO() {}

    // Getters
    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public List<ConcertDTO> getConcerts() { return concerts; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
    public void setConcerts(List<ConcertDTO> concerts) { this.concerts = concerts; }

    public static OrganisateurDetailsDTO fromEntity(Organisateur organisateur) {
        OrganisateurDetailsDTO dto = new OrganisateurDetailsDTO();
        dto.setId(organisateur.getId());
        dto.setNom(organisateur.getNom());
        dto.setEmail(organisateur.getEmail());

        if (organisateur.getConcerts() != null) {
            dto.setConcerts(
                    organisateur.getConcerts().stream()
                            .map(ConcertDTO::fromEntity)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
