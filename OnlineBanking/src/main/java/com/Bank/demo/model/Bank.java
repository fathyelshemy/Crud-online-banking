package com.Bank.demo.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="bank")
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bank_id")
	private Long id;
	@NotNull
	@Size(min=3,max=20)
	@Column(name="bank_name")
	private String name;
	@NotNull
	@Embedded
	@AttributeOverrides(value={
		@AttributeOverride(name="bank_country",column=@Column(name="country")),
		@AttributeOverride(name="bank_governate",column=@Column(name="governate")),
		@AttributeOverride(name="bank_district",column=@Column(name="district")),
		@AttributeOverride(name="bank_city",column=@Column(name="city")),
		@AttributeOverride(name="bank_street",column=@Column(name="street")),
		@AttributeOverride(name="bank_buildingNumber",column=@Column(name="buildingNumber")),
		@AttributeOverride(name="bank_zipCode",column=@Column(name="zipCode"))
	})
	private Address address;
	@NotNull
	@Size(min=8,max=20)
	@Column(name="mobile_number")
	private String mobileNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
		Bank other = (Bank) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", address=" + address + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
