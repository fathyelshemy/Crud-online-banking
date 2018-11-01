package com.Bank.demo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity(name="client")
public class Client{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="client_id")
	private Long id;
	@Column(name="clientName")
	private String clientName;
	
	@Email
	@NotNull
	@Column(name="email",unique=true)
	private String email;
	@NotNull
	@Column(name="password")
	private String password;
	@Column(name="mobile_number")
	private String mobileNumber;
	@NotNull
	@Embedded
	@AttributeOverrides(value={
		@AttributeOverride(name="client_country",column=@Column(name="country")),
		@AttributeOverride(name="client_governate",column=@Column(name="governate")),
		@AttributeOverride(name="client_district",column=@Column(name="district")),
		@AttributeOverride(name="client_city",column=@Column(name="city")),
		@AttributeOverride(name="client_street",column=@Column(name="street")),
		@AttributeOverride(name="client_buildingNumber",column=@Column(name="buildingNumber")),
		@AttributeOverride(name="client_zipCode",column=@Column(name="zipCode"))
	})
	private Address userAddress;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
