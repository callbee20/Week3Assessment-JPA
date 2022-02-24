package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 21, 2022
 */
@Entity
@Table(name= "listener")
public class Listener {

	@Id
	@GeneratedValue
	private int id;
	private String listenerName;
	
	public Listener() {
		super();
	}
	
	public Listener(int id, String listenerName) {
		super();
		this.id = id;
		this.listenerName = listenerName;
	}
	
	public Listener(String listenerName) {
		super();
		this.listenerName = listenerName;
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
	 * @return the listenerName
	 */
	public String getListenerName() {
		return listenerName;
	}

	/**
	 * @param listenerName the listenerName to set
	 */
	public void setListenerName(String listenerName) {
		this.listenerName = listenerName;
	}

	@Override
	public String toString() {
		return "Listener [id=" + id + ", listenerName=" + listenerName + "]";
	}
	
	
	
}
