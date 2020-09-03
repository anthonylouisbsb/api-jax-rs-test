package me.anthonylouis.server.dao;

import static com.mongodb.client.model.Filters.eq;
import static java.util.Optional.empty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import me.anthonylouis.server.databases.mongodb.MongoDBClient;
import me.anthonylouis.server.entity.Country;
import me.anthonylouis.utils.json.JsonUtils;
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
  public String getListOfCountries() {
    final MongoCollection<Document> collection = MongoDBClient.INSTANCE
        .getDatabase()
        .getCollection(COUNTRIES_COLLECTION);

    final var iterator = collection
        .find()
        .iterator();

    final var countries = new LinkedList<>();

    while (iterator.hasNext()) {
      final Document countryMetadataFromMongo = iterator.next();

      parseMongoDocumentToObject(countryMetadataFromMongo)
          .ifPresent(countries::add);
    }

    try {
      return JsonUtils.INSTANCE.writeObjectAsJsonString(countries);
    } catch (JsonProcessingException e) {
      // TODO: add this error on log
      throw new RuntimeException("Could not parse countries json!", e);
    }
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
