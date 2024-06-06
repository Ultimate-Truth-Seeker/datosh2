package com.example.datosh2.controller;

import com.example.datosh2.model.Country;
import com.example.datosh2.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country/")
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

    @PutMapping("{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
        return countryService.updateById(id, country);
    }

    @DeleteMapping("{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteById(id);
    }
}
