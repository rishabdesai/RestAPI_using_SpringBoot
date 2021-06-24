package com.pages.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pages.demo.beans.Country;
import com.pages.demo.controllers.AddResponse;

@Component
public class CountryService {

	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();

		Country indiaCountry = new Country(1, "India", "Delhi");
		Country usaCountry = new Country(2, "USA", "Washington");
		Country ukCountry = new Country(3, "UK", "London");

		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);

	}

	// get request - show all countries
	public List getAllCountries() {
		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}

	// get request - show country using id
	public Country getCountrybyID(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	// get request - get country using name
	public Country getCountrybyName(String countryName) {
		Country country = null;
		for (int i : countryIdMap.keySet()) {
			if (countryIdMap.get(i).getCountryName().equals(countryName))
				country = countryIdMap.get(i);
		}
		return country;
	}

	// post request - add a new country
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}

	// utility method to get max ID
	public final int getMaxId() {
		int max = 0;
		for (int id : countryIdMap.keySet())
			if (max <= id)
				max = id;
		return max + 1;
	}

	// put request - update 
	public Country updateCountry(Country country) {
		if (country.getId() > 0)
			countryIdMap.put(country.getId(), country);
		return country;
	}

	// delete request
	public AddResponse deleteCountry(int id) {
		countryIdMap.remove(id);
		AddResponse res = new AddResponse();
		res.setMsg("country deleted.....");
		res.setId(id);
		return res;
	}

}
