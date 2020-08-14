package me.anthonylouis.server.databases.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.io.Closeable;
import java.io.IOException;

public class MongoDBClient implements Closeable {

  private static MongoDatabase dataSource;

  /*Represents the connection session between program and MongoDB data source.*/
  private static MongoClient mongoDbClient;

  private static MongoDatabase getDatabase() {
    synchronized (dataSource){
      if (dataSource == null){
        mongoDbClient= new MongoClient();

        dataSource = mongoDbClient.getDatabase("api-jax-rs");
      }
    }

    return dataSource;
  }

  public void close() throws IOException {
    mongoDbClient.close();
  }
}
