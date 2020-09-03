package me.anthonylouis.server.dao;

import me.anthonylouis.server.utils.system.EnvironmentVariables;

/**
 * Handles all DAO's used by the system.
 */
public enum DaoManager {
  INSTANCE;

  private final DaoImplementation daoImplementation;

  private CountryDao countryDao;

  DaoManager() {
    final String usedDatabase = EnvironmentVariables.getEnvironmentVariable("USED_DATABASE");
    this.daoImplementation = DaoImplementation.fromString(usedDatabase);
  }

  /**
   * Gets the dao instance used to access country resources.
   *
   * @return the dao instance used to access country resources
   */
  public CountryDao getCountryDao() {
    if (this.countryDao != null) {
      return this.countryDao;
    }

    final String countryDaoImplementationClass = this.daoImplementation
        .getCountryDaoImplementationClass();

    try {
      this.countryDao = (CountryDao) Class
          .forName(countryDaoImplementationClass)
          .getDeclaredConstructor()
          .newInstance();

      return this.countryDao;
    } catch (final Exception exception) {
      // TODO: add log about this error
      throw new RuntimeException("Could not initialize DAO for Country object!", exception);
    }
  }
}
