package com.qaproject.demo.address;

public class Address {
	
	private String label; //= "Invalidenstraße 117, 10115 Berlin, Deutschland"
	
    private String countryCode; //DEU
    private String countryName; //Deutschland
    private String stateCode; //BE",
    private String state; //Berlin",
    private String countyCode; //B",
    private String county; //Berlin",
    private String city; //Berlin",
    private String district; //Mitte",
    private String street; //Invalidenstraße",
    private String postalCode; //10115",
    private String houseNumber; //117"
    private String localNumber;

	private double lat;
	private double lng;
	
	Address(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	Address(String houseNumber, String street, String postalCode, String city) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.label = street + " " + houseNumber + ", " + postalCode + " " + city;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLocalNumber() {
		return localNumber;
	}
	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public boolean setLatLng(String label) {
		this.lat = 0.0;
		this.lng = 0.0;
		return true;
	}

}
