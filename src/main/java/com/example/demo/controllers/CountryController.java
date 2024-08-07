package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Country;
import com.example.demo.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping("/getCountries")
	public List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping("/getCountries/{id}")
	public Country getCountryById(@PathVariable(value = "id") int id) {
		return countryService.getCountryById(id);
	}

	@GetMapping("/getCountries/countryName")
	public Country getCountryByName(@RequestParam(value = "name") String countryName) {
		return countryService.getCountryByName(countryName);
	}

	@DeleteMapping("/deleteCountry/{id}")
	public AddResponse deleteCountryById(@PathVariable(value = "id") int id) {
		return countryService.deleteCountryById(id);
	}

	@DeleteMapping("/deleteCountry/countryName")
	public AddResponse deleteCountryByName(@RequestParam(value = "name") String countryName) {
		return countryService.deleteCountryByName(countryName);
	}
	
	@PostMapping("/addCountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updateCountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}
}
