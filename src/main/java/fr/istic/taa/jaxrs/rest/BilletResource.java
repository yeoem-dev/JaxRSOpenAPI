package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.concert.Billet;
import fr.istic.taa.jaxrs.dao.generic.*;
import fr.istic.taa.jaxrs.dto.BilletDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Path("/billets")
@Produces("application/json")
@Consumes("application/json")
public class BilletResource {

    private BilletDao billetDao = new BilletDao();

    @GET
    @Path("/{id}")
    public Response getBilletById(@PathParam("id") Long id) {
        Billet billet = billetDao.findOne(id);
        if (billet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        BilletDTO dto = BilletDTO.fromEntity(billet);
        return Response.ok(dto).build();
    }

    @POST
    public Response createBillet(BilletDTO dto) {
        AcheteurDao acheteurDao = new AcheteurDao();
        ConcertDao concertDao = new ConcertDao();
        OrganisateurDao organisateurDao = new OrganisateurDao();
        CategorieDao categorieDao = new CategorieDao();
        BilletDao billetDao = new BilletDao();

        // 🔎 Vérifications
        var acheteur = acheteurDao.findOne(dto.getAcheteurId());
        var concert = concertDao.findOne(dto.getConcertId());
        var categorie = categorieDao.findOne(dto.getCategorieId());

        if (acheteur == null || concert == null || categorie == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Acheteur, concert ou catégorie introuvable.").build();
        }

        if (concert.getOrganisateur() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Concert invalide : aucun organisateur assigné.").build();
        }

        // 🎫 Création du billet
        Billet billet = new Billet();
        billet.setAcheteur(acheteur);
        billet.setConcert(concert);
        billet.setCategorie(categorie);
        billet.setDateAchat(LocalDateTime.now());

        billetDao.save(billet);
        return Response.status(Response.Status.CREATED)
                .entity("Billet acheté avec succès. ID: " + billet.getId()).build();
    }

    @GET
    public List<BilletDTO> getAllBillets() {
        return billetDao.findAll().stream()
                .map(BilletDTO::fromEntity)
                .collect(Collectors.toList());
    }

}
