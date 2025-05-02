package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.concert.Categorie;
import fr.istic.taa.jaxrs.dao.generic.CategorieDao;
import fr.istic.taa.jaxrs.dto.CategorieDTO;

import fr.istic.taa.jaxrs.dto.OrganisateurDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategorieResource {

    private CategorieDao categorieDao = new CategorieDao();

    @POST
    public Response createCategorie(CategorieDTO dto) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(dto.getLibelle());
        categorie.setPrix(dto.getPrix());

        categorieDao.save(categorie);
        return Response.status(Response.Status.CREATED).entity("Catégorie créée avec ID: " + categorie.getId()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCategorie(@PathParam("id") Long id) {
        Categorie categorie = categorieDao.findOne(id);
        if (categorie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        CategorieDTO dto = CategorieDTO.fromEntity(categorie);
        return Response.ok(dto).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategorieDTO> getAllCategories() {
        return categorieDao.findAll().stream()

                .map(CategorieDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
