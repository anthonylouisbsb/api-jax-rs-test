package me.anthonylouis.server.databases.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.io.Closeable;
import java.io.IOException;
import java.util.Optional;

/**
 * Is responsible to handle the connection with MongoDB database.
 */
public enum MongoDBClient implements Closeable {

  INSTANCE;

  private MongoDatabase dataSource;

  /*Represents the connection session between program and MongoDB data source.*/
  private Optional<MongoClient> mongoDbClient = Optional.empty();

  /**
   * Gets the database used to insert data on MongoD
   * <p>
   * It ensures that program is connected with MongoDB.
   *
   * @return the database used to insert api data inside MongoDB
   */
  public MongoDatabase getDatabase() {
    synchronized (dataSource) {
      if (dataSource == null) {
        mongoDbClient = Optional.of(new MongoClient());

        dataSource = mongoDbClient
            .map(client -> client.getDatabase("api-jax-rs"))
            .orElseThrow(() -> new RuntimeException("Did not find the api-jax-rs database"));
      }
    }

    return dataSource;
  }

  public void close() throws IOException {
    mongoDbClient.ifPresent(MongoClient::close);
  }
}
