package com.github.kwesidev.restapp.models;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Client {

	@NotBlank(message = "ID Number is required")
	String idNumber;
	@NotBlank(message = "FirstName is required")
	private String firstName;

	@NotBlank(message = "Last Name is required")
	private String lastName;

	@NotNull(message = "MobileNumber is required")
	private String mobileNumber;

	private String address;

	public Client() {

	}

	public Client(String idNumber, String firstName, String lastName, String mobileNumber, String address) {
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdNumber() {
		return idNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, idNumber, lastName, mobileNumber);
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
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(idNumber, other.idNumber) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mobileNumber, other.mobileNumber);
	}

	@Override
	public String toString() {
		return "Client [idNumber=" + idNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}

}
