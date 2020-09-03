package me.anthonylouis.server.dao;

import java.util.List;
import java.util.Optional;
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
  Optional<Country> getCountryById(final int id);

  /**
   * Gets all created countries, serialized as a string
   *
   * @return all countries stored in database
   */
  List<Country> getListOfCountries();
}
