package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListBand;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 2, 2022
 */
public class BandHelper {
	
	//this allows java persistence to help establish a connection with the database
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week3Assessment");
	
	//This method communicates with the ListBand class and addAnItem method in the StartProgram class in order to enter a band into the database
	public void insertBand(ListBand lb) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lb);
		em.getTransaction().commit();
		em.close();
	}
	
	//This method communicates with the ListBand class and editAnItem method in the StartProgram class in order to show all bands entered in the database
	public List<ListBand> showAllBands(){
		EntityManager em = emfactory.createEntityManager();
		List<ListBand> allBands = em.createQuery("SELECT b FROM ListBand b").getResultList();
		return allBands;
	}
	
	//This method communicates with the ListBand class and deleteAnItem method in the StartProgram class in order to remove a band from the database
	public void deleteBand(ListBand toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBand> typedQuery = em.createQuery("select bh from ListBand bh where bh.bandName = :selectedBandName and bh.genre = :selectedGenre and bh.favSong = :selectedFavSong", ListBand.class);
		typedQuery.setParameter("selectedBandName", toDelete.getBandName());
		typedQuery.setParameter("selectedGenre", toDelete.getGenre());
		typedQuery.setParameter("selectedFavSong", toDelete.getFavSong());
		typedQuery.setMaxResults(1);
		ListBand result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//This list communicates with the ListBand class and the editAnItem method in the StartProgram class to allow a user to search for a band entry by the name of the band
	public List<ListBand> searchForBandByName(String bandName){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBand> typedQuery = em.createQuery("select bh from ListBand bh where bh.bandName = :selectedBandName", ListBand.class);
		typedQuery.setParameter("selectedBandName", bandName);
		List<ListBand> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	//This list communicates with the ListBand class and the editAnItem method in the StartProgram class to allow a user to search for a band entry by the genre of the band
	public List<ListBand> searchForBandByGenre(String genre){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListBand> typedQuery = em.createQuery("select bh from ListBand bh where bh.genre = :selectedGenre", ListBand.class);
		typedQuery.setParameter("selectedGenre", genre);
		List<ListBand> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	//This list communicates with the ListBand class and the editAnItem method in the StartProgram class to allow a user to search for a band entry by the id entry of the band
	public ListBand searchForBandById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListBand found = em.find(ListBand.class, idToEdit);
		em.close();
		return found;
	}
	
	//This method communicates with the ListBand class and the editAnItem method in the StartProgram class to allow a user to update/edit a band entry from the database
	public void updateBand(ListBand toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	//This method communicates with the runMenu method in the StartProgram class in order to close the program and connection to the database properly
	public void cleanUp() {
		emfactory.close();
	}
}
