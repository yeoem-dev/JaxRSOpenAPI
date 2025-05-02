package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.concert.Organisateur;
import fr.istic.taa.jaxrs.dao.generic.OrganisateurDao;
import fr.istic.taa.jaxrs.dto.ConcertDTO;
import fr.istic.taa.jaxrs.dto.OrganisateurDTO;
import fr.istic.taa.jaxrs.dto.OrganisateurDetailsDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/organisateurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrganisateurResource {

    private OrganisateurDao organisateurDao = new OrganisateurDao();

    // ➕ Créer un organisateur
    @POST
    public Response createOrganisateur(OrganisateurDTO dto) {
        if (dto == null || dto.getNom() == null || dto.getEmail() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Données invalides").build();
        }

        Organisateur organisateur = new Organisateur();
        organisateur.setNom(dto.getNom());
        organisateur.setEmail(dto.getEmail());

        organisateurDao.save(organisateur);
        return Response.status(Response.Status.CREATED)
                .entity("Organisateur créé avec ID: " + organisateur.getId()).build();
    }

    // 🔍 Obtenir un organisateur simple
    @GET
    @Path("/{id}")
    public Response getOrganisateur(@PathParam("id") Long id) {
        Organisateur organisateur = organisateurDao.findOne(id);
        if (organisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        OrganisateurDTO dto = OrganisateurDTO.fromEntity(organisateur);
        return Response.ok(dto).build();
    }

    // 📜 Liste des organisateurs
    @GET
    public List<OrganisateurDTO> getAllOrganisateurs() {
        return organisateurDao.findAll().stream()
                .map(OrganisateurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 📋 Détails d’un organisateur (avec concerts)
    @GET
    @Path("/{id}/details")
    public Response getOrganisateurDetails(@PathParam("id") Long id) {
        Organisateur organisateur = organisateurDao.findOne(id);
        if (organisateur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        OrganisateurDetailsDTO dto = new OrganisateurDetailsDTO();
        dto.setId(organisateur.getId());
        dto.setNom(organisateur.getNom());
        dto.setEmail(organisateur.getEmail());
        dto.setConcerts(
                organisateur.getConcerts().stream()
                        .map(ConcertDTO::fromEntity)
                        .collect(Collectors.toList())
        );

        return Response.ok(dto).build();
    }
}
