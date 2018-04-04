package org.shubham.javabrain.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class profile {

	private long id;
	private String profileName;
	private Date created;
	private String firstname;
	private String lastname;
	
	public profile () {
		
	}
	public profile(long id,String profileName,String firstname,String lastName){
		
		this.id = id;
		this.profileName = profileName;
		this.firstname = firstname;
		this.lastname = lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
