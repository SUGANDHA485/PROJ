package com.lti.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager(){
		if(entityManager == null)
			entityManager = Persistence.createEntityManagerFactory("JPA_PU").createEntityManager();
		return entityManager;
	}
}
