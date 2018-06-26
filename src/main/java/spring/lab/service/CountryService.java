package spring.lab.service;

import spring.lab.model.Country;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

public interface CountryService {

    public List<Country> getAllCountriesInsideTransaction(Propagation propagation);

    public List<Country> getAllCountriesRequired();

    public List<Country> getAllCountriesRequiresNew();

    public List<Country> getAllCountriesSupports();

    public List<Country> getAllCountriesNever();

    public List<Country> getAllCountriesMandatory();

    public List<Country> getAllCountriesNotSupported();

    public List<Country> getAllCountries();
}
