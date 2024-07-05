package com.cityclassified.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue
    private int adminId;
    private String adminEmail;
    private String adminPass;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<CityDetails> cityDetails;
    
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public Admin(int adminId) {
		super();
		this.adminId = adminId;
		
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String permanentAdminEmail, String permanentAdminPassword) {
		// TODO Auto-generated constructor stub
	}
	public List<CityDetails> getCityDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
