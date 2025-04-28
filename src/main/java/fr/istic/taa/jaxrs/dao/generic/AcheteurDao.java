package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.concert.Acheteur;
import fr.istic.taa.jaxrs.concert.Billet;

import java.util.List;

public class AcheteurDao extends AbstractJpaDao<Long, Acheteur> {

    public AcheteurDao() {
        super.setClazz(Acheteur.class);
    }

    public List<Billet> findBilletByAcheteurId(Long acheteurId) {
        return entityManager.createQuery(
                        "SELECT b FROM Billet b WHERE b.acheteur.id = :acheteurId", Billet.class)
                .setParameter("acheteurId", acheteurId)
                .getResultList();
    }

}
