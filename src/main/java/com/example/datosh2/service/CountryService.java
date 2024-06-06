package com.example.datosh2.service;

import com.example.datosh2.model.Country;
import com.example.datosh2.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    public Country save(Country country) {
        return countryRepository.save(country);
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country updateById(Long id, Country country) {
        Optional<Country> country1 = countryRepository.findById(id);
        if (country1.isPresent()) {
            country1.get().setName(country.getName());
            countryRepository.save(country1.get());
            return country1.get();
        }
        return null;
    }

    public void deleteById(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        }
    }

}
