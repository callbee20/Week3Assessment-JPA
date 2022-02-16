package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This makes the database know that this class is an entity, a class that should be persisted within the database
@Entity
@Table(name="band")
/**
 * @author Carson Allbee callbee
 *CIS175 - Fall 2021
 * Feb 2, 2022
 */
public class ListBand {
	
	//This identifies a primary key(column Id) to the database and allows the database to create columns filled with the user's entries
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int Id;
	@Column(name="BAND_NAME")
	private String bandName;
	@Column(name="GENRE")
	private String genre;
	@Column(name="FAVORITE_SONG")
	private String favSong;
	
	public ListBand(){
		
	}
	
	//this method helps allow user entries
	public ListBand(String bandName, String genre, String favSong) {
		this.bandName = bandName;
		this.genre = genre;
		this.favSong = favSong;
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getBandName() {
		return bandName;
	}

	/**
	 * @param name the name to set
	 */
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}


	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the favSong
	 */
	public String getFavSong() {
		return favSong;
	}

	/**
	 * @param favSong the favSong to set
	 */
	public void setFavSong(String favSong) {
		this.favSong = favSong;
	}
	
	//This method returns the details of the band that the user entered while running the StartProgram class
	public String bandDetails() {
		return this.bandName + " is a " + this.genre + " band that made the song " + this.favSong;
	}
	
}
