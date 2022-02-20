package com.mindsoft.immobilierproject.model;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String bio;
	private String departement;
	private String commune;
	private String adresse;
	private String telephone;
	private String email;
	private String facebook; 
	private String site;
	private String twitter;
	private String instagram;
	private String linkedin;
	private String youtube; 
    private String profession;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")	
	private Date profileDate;
    
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    public String photo;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date dateNaissance;
    
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;
    
    @OneToMany
    private List<Realisation> realisations;
	public Profile() {
		super();
	}
	
	public Profile(Long id, String username, String bio, String departement, String facebook, String site,
			String twitter, String instagram, String linkedin, String youtube) {
		super();
		this.id = id;
		this.username = username;
		this.bio = bio;
		this.departement = departement;
		this.facebook = facebook;
		this.site = site;
		this.twitter = twitter;
		this.instagram = instagram;
		this.linkedin = linkedin;
		this.youtube = youtube;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public Date getProfileDate() {
		return profileDate;
	}

	public void setProfileDate(Date profileDate) {
		this.profileDate = profileDate;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Realisation> getRealisations() {
		return realisations;
	}
	public void setRealisations(List<Realisation> realisations) {
		this.realisations = realisations;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Transient
    public String getPhotoImagePath() {
        if (photo == null || id == null) return null;
         
        return "user-photos/" + id + "/" + photo;
    }
  
}
