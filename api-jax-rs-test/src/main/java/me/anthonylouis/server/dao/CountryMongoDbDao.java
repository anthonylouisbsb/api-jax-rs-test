package me.anthonylouis.server.dao;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Optional.empty;

import com.mongodb.client.MongoCollection;
import java.util.List;
import java.util.Optional;
import me.anthonylouis.server.databases.mongodb.MongoDBClient;
import me.anthonylouis.server.entity.Country;
import org.bson.Document;

public class CountryMongoDbDao implements CountryDao {

  private static final String COUNTRIES_COLLECTION = "countries";

  @Override
  public Optional<Country> getCountryById(final int id) {
    final MongoCollection<Document> collection = MongoDBClient.INSTANCE
        .getDatabase()
        .getCollection(COUNTRIES_COLLECTION);

    final Document retrievedCountry = collection.find(eq("id", id)).first();

    return parseMongoDocumentToObject(retrievedCountry);
  }

  @Override
  public List<Country> getListOfCountries() {
    return null;
  }

  /**
   * Parse a Mongo's document to object with country metadata
   *
   * @param document the object representation retrieved from MongoDB
   * @return an object with country metadata
   */
  private Optional<Country> parseMongoDocumentToObject(final Document document) {
    if (document == null) {
      return empty();
    }

    final int countryId = document.getInteger("id");
    final var name = document.getString("name");
    final double maxLatitude = document.getDouble("max-latitude");
    final double minLatitude = document.getDouble("min-latitude");
    final double maxLongitude = document.getDouble("max-longitude");
    final double minLongitude = document.getDouble("min-longitude");

    final var countryRepresentation = Country
        .getBuilder()
        .withId(countryId)
        .withName(name)
        .withMaxLatitude(maxLatitude)
        .withMinLatitude(minLatitude)
        .withMaxLongitude(maxLongitude)
        .withMinLongitude(minLongitude)
        .build();

    return Optional.of(countryRepresentation);
  }
}
