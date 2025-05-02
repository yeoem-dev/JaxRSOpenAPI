package fr.istic.taa.jaxrs.dto;

public class CategorieDTO {

    private Long id;
    private String libelle;
    private Double prix;

    public CategorieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public static CategorieDTO fromEntity(fr.istic.taa.jaxrs.concert.Categorie categorie) {
        if (categorie == null) return null;

        CategorieDTO dto = new CategorieDTO();
        dto.setId(categorie.getId());
        dto.setLibelle(categorie.getLibelle());
        dto.setPrix(categorie.getPrix());
        return dto;
    }
}
