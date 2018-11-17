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

@Entity(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private Long id;
	
	@Column(name="employee_name")
	private String employeeName;
	@Email
	@NotNull
	@Column(name="email",unique=true)
	private String email;
	@NotNull
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	@Embedded
	@AttributeOverrides(value={
		@AttributeOverride(name="employee_country",column=@Column(name="country")),
		@AttributeOverride(name="employee_governate",column=@Column(name="governate")),
		@AttributeOverride(name="employee_district",column=@Column(name="district")),
		@AttributeOverride(name="employee_city",column=@Column(name="city")),
		@AttributeOverride(name="employee_street",column=@Column(name="street")),
		@AttributeOverride(name="employee_buildingNumber",column=@Column(name="buildingNumber")),
		@AttributeOverride(name="employee_zipCode",column=@Column(name="zipCode"))
	})
	private Address userAddress;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return employeeName;
	}
	public void setUserName(String userName) {
		this.employeeName = userName;
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
