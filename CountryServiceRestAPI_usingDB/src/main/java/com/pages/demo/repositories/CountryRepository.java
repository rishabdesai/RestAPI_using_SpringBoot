package com.pages.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pages.demo.beans.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
