package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListenerDetails;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
public class ListenerDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	public void insertNewListenerDetails(ListenerDetails l) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListenerDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<ListenerDetails> allDetails = em.createQuery("SELECT d FROM ListenerDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(ListenerDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListenerDetails> typedQuery = em.createQuery("select detail from ListenerDetails detail where detail.id = :selectedId", ListenerDetails.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		typedQuery.setMaxResults(1);
		ListenerDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public ListenerDetails searchForListenerDetailsById(int tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListenerDetails found = em.find(ListenerDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(ListenerDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
