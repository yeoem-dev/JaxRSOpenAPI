package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.concert.Organisateur;

public class OrganisateurDao extends AbstractJpaDao<Long, Organisateur> {
    public OrganisateurDao() {
        super.setClazz(Organisateur.class);
    }


}


