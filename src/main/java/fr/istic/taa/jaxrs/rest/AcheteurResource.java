package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.concert.Acheteur;
import fr.istic.taa.jaxrs.dao.generic.AcheteurDao;
import fr.istic.taa.jaxrs.dto.AcheteurDTO;
import fr.istic.taa.jaxrs.dto.AcheteurDetailsDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/acheteurs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcheteurResource {

    private AcheteurDao acheteurDao = new AcheteurDao();

    @POST
    public Response createAcheteur(AcheteurDTO dto) {
        Acheteur acheteur = new Acheteur();
        acheteur.setNom(dto.getNom());
        acheteur.setEmail(dto.getEmail());

        acheteurDao.save(acheteur);
        return Response.status(Response.Status.CREATED).entity("Acheteur créé avec ID: " + acheteur.getId()).build();
    }

    @GET
    @Path("/{id}")
    public Response getAcheteur(@PathParam("id") Long id) {
        Acheteur acheteur = acheteurDao.findOne(id);
        if (acheteur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AcheteurDetailsDTO dto = AcheteurDetailsDTO.fromEntity(acheteur); // inclut les billets
        return Response.ok(dto).build();
    }
    @GET
    public List<AcheteurDTO> getAllAcheteurs() {
        return acheteurDao.findAll().stream()
                .map(AcheteurDTO::fromEntity)
                .collect(Collectors.toList());
    }

}
