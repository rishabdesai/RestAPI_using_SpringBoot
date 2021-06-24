package com.pages.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pages.demo.beans.Country;
import com.pages.demo.controllers.AddResponse;
import com.pages.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {

	@Autowired
	CountryRepository countryrep;

	

	// get request - show all countries
	public List<Country> getAllCountries() {
		return countryrep.findAll();
	}

	// get request - show country using id
	public Country getCountrybyID(int id) {
		return countryrep.findById(id).get();
	}

	// get request - get country using name
	public Country getCountrybyName(String countryName) {
		
		List <Country> countries = countryrep.findAll();
		Country country = null;

		for(Country con:countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		return country;
	}

	// post request - add a new country
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
	}

	public int getMaxId() {
		return countryrep.findAll().size()+1;
	}
	

	// put request - update 
	public Country updateCountry(Country country) {
		countryrep.save(country);
		return country;
	}

	// delete request
	public AddResponse deleteCountry(int id) {
		countryrep.deleteById(id);
		
		AddResponse res = new AddResponse();
		res.setMsg("Country Deleted !!!    ");
		res.setId(id);
		return res;
		
	}

}
