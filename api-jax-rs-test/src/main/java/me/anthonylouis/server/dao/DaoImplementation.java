package me.anthonylouis.server.dao;

/**
 * Represents the many data sources that can be used by the program
 */
public enum DaoImplementation {
  MONGODB("me.anthonylouis.server.dao.CountryMongoDbDao");

  private final String countryDaoImplementationClass;

  DaoImplementation(final String countryDaoImplementationClass) {
    this.countryDaoImplementationClass = countryDaoImplementationClass;
  }

  public String getCountryDaoImplementationClass() {
    return this.countryDaoImplementationClass;
  }

  /**
   * Returns the type of the DAO that must be used by the application
   *
   * @param usedDatabase the database used by application(mongod, postgres..)
   * @return the object with which DAO instance must be used by the program
   */
  public static DaoImplementation fromString(final String usedDatabase) {
    return MONGODB;
  }
}
