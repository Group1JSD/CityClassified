package com.cityclassified.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue
	private int adminId;
	private String adminEmail;
	private String adminPass;
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
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public Admin(int adminId, String adminEmail, String adminPass) {
		super();
		this.adminId = adminId;
		this.adminEmail = adminEmail;
		this.adminPass = adminPass;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
