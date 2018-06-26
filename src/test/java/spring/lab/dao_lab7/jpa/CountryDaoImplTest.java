package spring.lab.dao_lab7.jpa;

import spring.lab.dao_lab7.CountryDao;
import spring.lab.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class CountryDaoImplTest {

//	private static Log log = LogFactory.getLog(CountryDaoImplTest.class);

	private Country exampleCountry = new Country("Australia", "AU");

	@Autowired
	private CountryDao countryDao_lab7;

	@Test
	public void testSaveCountry() {

		countryDao_lab7.save(exampleCountry);

		List<Country> countryList = countryDao_lab7.getAllCountries();
		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	public void testGtAllCountries() {

		countryDao_lab7.save(new Country("Canada", "CA"));

		List<Country> countryList = countryDao_lab7.getAllCountries();
		assertEquals(2, countryList.size());
	}

	@Test
	public void testGetCountryByName() {

		Country country = countryDao_lab7.getCountryByName("Australia");
		assertEquals(exampleCountry, country);
	}

}
