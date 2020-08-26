package me.anthonylouis.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Is an wrapper for Jackson library, used to read/write JSON
 */
public enum JsonUtils {
  INSTANCE;

  private final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * Serialize an object to a JSON string
   *
   * @param objectToBeSerialized a generic object to be serialized
   * @return the object in JSON format
   * @throws JsonProcessingException if Jackson can not serialize the object
   */
  public String writeObjectAsJsonString(final Object objectToBeSerialized)
      throws JsonProcessingException {
    return objectMapper.writeValueAsString(objectToBeSerialized);
  }
}
