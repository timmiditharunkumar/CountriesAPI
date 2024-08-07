package com.example.demo.models;

public class Country {

	public int id;
	public String country;
	public String capital;

	public Country(int id, String country, String capital) {
		this.id = id;
		this.country = country;
		this.capital = capital;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}
