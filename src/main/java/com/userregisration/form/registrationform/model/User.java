package com.userregisration.form.registrationform.model;

import javax.persistence.Column;
//import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String email;
	private String phonenumber;
	private String gender;
	private String state;
	private String skills;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	/*private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public User(String name, String email, String phonenumber, String gender, String state, String skills,
			String image) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.state = state;
		this.skills = skills;
		this.image = image;
	}
	public User() {
		super();
	}
	/*public User(String name2, String email2, String phonenumber2, String gender2, String state2, String skills2,
			String uriString) {
		// TODO Auto-generated constructor stub
	}*/
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + ", gender="
				+ gender + ", state=" + state + ", skills=" + skills + ", image=" + image + "]";
	}
	
	
}
