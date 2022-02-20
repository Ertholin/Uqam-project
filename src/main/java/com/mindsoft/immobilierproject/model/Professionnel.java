package com.mindsoft.immobilierproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professionnel")
public class Professionnel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "nom", length = 80)
    public String nom;

    @Column(name = "prenom", length = 100)
    public String prenom;
	
	private String email;
	
	@Column(name = "addresse")
	private String adresse;
		
    @Column(name = "sexe", length = 10)
    private String sexe;
    
    @Column(name = "telephone", length = 20)
    private String telephone;
    
    @Column(name = "photo", length = 255)
	private String photo; 
	
	@OneToOne
	private User user;
	
	public Professionnel() {
		
	}

	public Professionnel(Long id, String nom, String prenom, String email, String adresse, String sexe,
			String telephone, String photo, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.sexe = sexe;
		this.telephone = telephone;
		this.photo = photo;
		this.user = user;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
