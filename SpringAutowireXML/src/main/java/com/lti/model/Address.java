package com.lti.model;

public class Address {
	private int addressId;
	private String city;
	private int pin;
	
	public Address() {
		System.out.println(" ----- Address() -----");
	}
	
	public Address(int addressId, String city, int pin) {
		super();
		System.out.println(" ----- Address(-,-,-) -----");
		this.addressId = addressId;
		this.city = city;
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pin=" + pin + "]";
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	
}
