package com.cityclassified.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Classifieds {
	@Id
	@GeneratedValue
	private int classifiedId;
	private String classifiedTitle;
	private String description;
	private String classifiedCategory;
	private String mobile;
	private String address;
	private String cityName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", nullable = false)
    private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_Id")
    private CityDetails cityDetails;
    
    public int getClassifiedId() {
		return classifiedId;
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
	
	
}
