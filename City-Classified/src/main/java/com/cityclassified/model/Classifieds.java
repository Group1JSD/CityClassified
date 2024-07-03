package com.cityclassified.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Classifieds {
	@Id
	@GeneratedValue
	private int classFieldId;
	private int userId;
	private String userName;
	private String userEmail;
	private String classifiedTitle;
	public int getClassFieldId() {
		return classFieldId;
	}
	public void setClassFieldId(int classFieldId) {
		this.classFieldId = classFieldId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getClassifiedTitle() {
		return classifiedTitle;
	}
	public void setClassifiedTitle(String classifiedTitle) {
		this.classifiedTitle = classifiedTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClassifiedCategory() {
		return classifiedCategory;
	}
	public void setClassifiedCategory(String classifiedCategory) {
		this.classifiedCategory = classifiedCategory;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	private String description;
	private String classifiedCategory;
	private String mobile;
	private String address;
	private String cityName;
}
