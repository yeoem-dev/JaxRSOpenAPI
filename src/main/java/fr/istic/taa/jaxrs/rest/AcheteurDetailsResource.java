package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.concert.Acheteur;
import fr.istic.taa.jaxrs.dao.generic.AcheteurDao;
import fr.istic.taa.jaxrs.dto.AcheteurDetailsDTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/acheteurs/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcheteurDetailsResource {

    private AcheteurDao acheteurDao = new AcheteurDao();



    @GET
    @Path("/{id}/details")
    public Response getAcheteurDetails(@PathParam("id") Long id) {
        Acheteur acheteur = acheteurDao.findWithBillets(id);
        if (acheteur == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        AcheteurDetailsDTO dto = AcheteurDetailsDTO.fromEntity(acheteur);
        return Response.ok(dto).build();
    }

}
