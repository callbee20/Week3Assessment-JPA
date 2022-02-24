package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Listener;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
public class ListenerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertListener(Listener l) {
		EntityManager em = emfactory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Listener> showAllListeners(){
		EntityManager em = emfactory.createEntityManager();
		List<Listener> allListeners = em.createQuery("SELECT l FROM Listener l").getResultList();
		return allListeners;
	}
	
	public Listener findListener(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Listener> typedQuery = em.createQuery("select lh from Listener lh where lh.listenerName = :selectedName", Listener.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Listener foundListener;
		try {
			foundListener = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundListener = new Listener(nameToLookUp);
		}
		em.close();
		
		return foundListener;
	}
	
}
