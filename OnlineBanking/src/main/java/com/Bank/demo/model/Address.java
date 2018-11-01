package com.Bank.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String country;
	private String governate;
	private String district;
	private String city;
	private String street;
	private String buildingNumber;
	private String zipCode;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGovernate() {
		return governate;
	}
	public void setGovernate(String governate) {
		this.governate = governate;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBuildingNumber() {
		return buildingNumber;
	}
	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [country=" + country + ", governate=" + governate + ", district=" + district + ", city=" + city
				+ ", street=" + street + ", buildingNumber=" + buildingNumber + ", zipCode=" + zipCode + "]";
	}
	
	
	
}
