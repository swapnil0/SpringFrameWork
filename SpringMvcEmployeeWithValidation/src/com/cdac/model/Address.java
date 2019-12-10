package com.cdac.model;

import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("address")
@Scope(scopeName="prototype")
public class Address {
	@NotNull(message = "please enter this")
	private Integer addressId;
	
	private String street, city, pin;
	
	public Address() {
		System.out.println("Address object created.");
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", pin=" + pin + "]";
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
}
