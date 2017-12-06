package com.slurp.web.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Hotels implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Hotel name cannot be empty")
	@Size(min = 6, message = "Must be greater than 5 characters")
	private String hotelName;
	private int merchantID;
	@NotBlank(message = "Cannot be empty")
	private String streetName;
	@NotBlank(message = "Cannot be empty")
	private String city;
	@NotBlank(message = "Cannot be empty")
	private String state;
	@NotBlank(message = "Cannot be empty")
	private String gstNumber;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(int merchantID) {
		this.merchantID = merchantID;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

}
