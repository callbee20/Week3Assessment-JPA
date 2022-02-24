package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
@Entity
public class ListenerDetails {

	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate enteredDate;
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Listener listener;
	@OneToMany(cascade=CascadeType.PERSIST, fetch= FetchType.EAGER)
	private List<ListBand> listOfBands;
	
	public ListenerDetails() {
		super();
	}
	
	public ListenerDetails(int id, String listName, LocalDate enteredDate, Listener listener, List<ListBand> listOfBands) {
		super();
		this.id = id;
		this.listName = listName;
		this.enteredDate = enteredDate;
		this.listener = listener;
		this.listOfBands = listOfBands;
	}
	
	public ListenerDetails(String listName, LocalDate enteredDate, Listener listener, List<ListBand> listOfBands) {
		this.listName = listName;
		this.enteredDate = enteredDate;
		this.listener = listener;
		this.listOfBands = listOfBands;
	}
	
	public ListenerDetails(String listName, LocalDate enteredDate, Listener listener) {
		this.listName = listName;
		this.enteredDate = enteredDate;
		this.listener = listener;
	
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}

	/**
	 * @return the enteredDate
	 */
	public LocalDate getEnteredDate() {
		return enteredDate;
	}

	/**
	 * @param enteredDate the enteredDate to set
	 */
	public void setEnteredDate(LocalDate enteredDate) {
		this.enteredDate = enteredDate;
	}

	/**
	 * @return the listener
	 */
	public Listener getListener() {
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public void setListener(Listener listener) {
		this.listener = listener;
	}

	/**
	 * @return the listOfBands
	 */
	public List<ListBand> getListOfBands() {
		return listOfBands;
	}

	/**
	 * @param listOfBands the listOfBands to set
	 */
	public void setListOfBands(List<ListBand> listOfBands) {
		this.listOfBands = listOfBands;
	}

	@Override
	public String toString() {
		return "ListenerDetails [id=" + id + ", listName=" + listName + ", enteredDate=" + enteredDate + ", listener="
				+ listener + ", listOfBands=" + listOfBands + "]";
	}
	
}
