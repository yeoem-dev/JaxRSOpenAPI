package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.concert.Concert;

import java.util.List;

public class ConcertDao extends AbstractJpaDao<Long, Concert> {
    public ConcertDao() {
        super.setClazz(Concert.class);
    }

    public List<Concert> findByOrganisateurId(Long organisateurId) {
        return entityManager.createQuery(
                        "SELECT c FROM Concert c WHERE c.organisateur.id = :organisateurId", Concert.class)
                .setParameter("organisateurId", organisateurId)
                .getResultList();
    }

}
