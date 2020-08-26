package me.anthonylouis.server.dao;

import java.util.List;
import me.anthonylouis.server.entity.Country;

/**
 * Used to retrieves countries from the database
 */
public interface CountryDao {

  /**
   * Gets a country by its database identifier
   *
   * @param id the country identifier in database
   * @return an object with country metadata
   */
  public Country getCountryById(final int id);

  /**
   * Gets all created countries
   *
   * @return all countries stored in database
   */
  public List<Country> getListOfCountries();
}
