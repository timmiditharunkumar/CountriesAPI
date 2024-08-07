package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.controllers.AddResponse;
import com.example.demo.models.Country;

@Component
public class CountryService {

	static HashMap<Integer, Country> countries;

	public CountryService() {
		countries = new HashMap<Integer, Country>();

		Country india = new Country(1, "INDIA", "Dehli");
		Country usa = new Country(2, "USA", "Washington");
		Country japan = new Country(3, "JAPAN", "Tokyo");

		countries.put(1, india);
		countries.put(2, usa);
		countries.put(3, japan);
	}

	public List<Country> getAllCountries() {
		List<Country> allCountries = new ArrayList<Country>(countries.values());
		return allCountries;
	}

	public Country getCountryById(int id) {
		return countries.get(id);
	}

	public Country getCountryByName(String countryName) {
		Country country = null;
		for (int i : countries.keySet()) {
			if (countries.get(i).country.equalsIgnoreCase(countryName)) {
				country = countries.get(i);
			}
		}

		return country;
	}

	public Country addCountry(Country country) {
		int maxId = Collections.max(countries.keySet());
		countries.put(maxId + 1, country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() > 0)
			countries.put(country.getId(), country);
		return country;
	}

	public AddResponse deleteCountryById(int id) {
		AddResponse res = new AddResponse();
		for (int i : countries.keySet()) {
			if (countries.get(i).id == id) {
				res.setCountryName(countries.get(i).country);
			}
		}
		countries.remove(id);
		res.setMsg("Country Deleted .... ");
		res.setId(id);

		return res;
	}

	public AddResponse deleteCountryByName(String countryName) {
		AddResponse res = new AddResponse();
		for (int i : countries.keySet()) {
			if (countries.get(i).country.equalsIgnoreCase(countryName)) {
				res.setId(countries.get(i).id);
				countries.remove(i);
			}
		}
		res.setMsg("Country Deleted .... ");
		res.setCountryName(countryName);

		return res;
	}
}
