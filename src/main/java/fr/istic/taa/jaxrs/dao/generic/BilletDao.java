package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.concert.Billet;

import java.util.List;

public class BilletDao extends AbstractJpaDao<Long, Billet> {
    public BilletDao() {
        super.setClazz(Billet.class);
    }

    public List<Billet> findByConcertId(Long concertId) {
        return entityManager.createQuery(
                        "SELECT b FROM Billet b WHERE b.concert.id = :concertId", Billet.class)
                .setParameter("concertId", concertId)
                .getResultList();
    }

}
