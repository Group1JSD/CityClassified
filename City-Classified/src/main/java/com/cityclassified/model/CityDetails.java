package com.cityclassified.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class CityDetails {
	@Id
    @GeneratedValue
    private int cityId;
    private String city;
    private String category;
    private String name;
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "admin_Id", nullable=false)
    private Admin admin;

    public CityDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	@OneToMany(mappedBy = "cityDetails", cascade = CascadeType.ALL)
    private List<Classifieds> classifieds;
    
    public CityDetails(String cityName) {
		// TODO Auto-generated constructor stub
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	public List<Classifieds> getClassifieds() {
		// TODO Auto-generated method stub
		return null;
	}
}
