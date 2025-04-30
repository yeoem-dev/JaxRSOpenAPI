package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.concert.Acheteur;

import java.util.List;
import java.util.stream.Collectors;

public class AcheteurDetailsDTO extends AcheteurDTO {

    private List<BilletDTO> billets;

    public List<BilletDTO> getBillets() {
        return billets;
    }


    public void setBillets(List<BilletDTO> list) {
        this.billets = list;
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