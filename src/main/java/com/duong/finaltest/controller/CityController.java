package com.duong.finaltest.controller;

import com.duong.finaltest.model.City;
import com.duong.finaltest.model.Country;
import com.duong.finaltest.service.city.ICityService;
import com.duong.finaltest.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICountryService countryService;

    @Autowired
    private ICityService cityService;

    @GetMapping("/countries")
    public ResponseEntity<Iterable<Country>> getAllCountry () {
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> countryOptional = countryService.findById(id);
        if (!countryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(countryOptional.get(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<City>> getAllCity() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById (@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> createCity(@ModelAttribute City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<City> editCity (@PathVariable Long id, @ModelAttribute City city){
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String name = city.getName();
        Country country = city.getCountry();
        double acreage = city.getAcreage();
        double population = city.getPopulation();
        double gdp = city.getGdp();
        String description = city.getDescription();

        City newCity = new City(name, country, acreage, population, gdp, description);
        newCity.setId(id);
        cityService.save(newCity);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity  (@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
