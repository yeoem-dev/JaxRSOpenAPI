package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.concert.Billet;
import fr.istic.taa.jaxrs.concert.Categorie;


import java.util.List;

public class CategorieDao extends AbstractJpaDao<Long, Categorie> {
    public CategorieDao() {
        super.setClazz(Categorie.class);
    }

    public List<Billet> getBilletsByCategorieId(Long categorieId) {
        return entityManager.createQuery(
                        "SELECT b FROM Billet b WHERE b.categorie.id = :categorieId", Billet.class)
                .setParameter("categorieId", categorieId)
                .getResultList();
    }


}
