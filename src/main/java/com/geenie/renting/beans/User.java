package com.geenie.renting.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "username", "mail" }) })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	private String firstName;
	private String lastName;
	@NotNull
	@Column(unique = true)
	private String mail;
	@NotNull
	@Column(unique = true)
	private String username;
	private String password;
	private int age;
	private int telephoneNumber;
	private boolean isActive;
	private boolean isBlocked;
	@Lob
	private byte[] picture;
	@ManyToMany
	private List<Stay> stays;
	@ManyToMany()
	private List<Appartment> appartmentsOwned;
	@ManyToMany()
	private List<Appartment> appartmentsStayed;
	private static final long serialVersionUID = 1L;
	
	public User() {
	}

	
	public User(String firstName, String lastName, String mail, String username, String password, int age,
			int telephoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.age = age;
		this.telephoneNumber = telephoneNumber;
		this.isActive = false;
		this.isBlocked = false;
	}


	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(int telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}


	public List<Stay> getStays() {
		return stays;
	}


	public void setStays(List<Stay> stays) {
		this.stays = stays;
	}
	
}
