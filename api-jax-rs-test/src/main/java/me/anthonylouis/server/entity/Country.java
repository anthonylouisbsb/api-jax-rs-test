package me.anthonylouis.server.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import me.anthonylouis.utils.json.JsonUtils;

@JsonPropertyOrder(alphabetic = true)
public class Country {

  public Country(final int id, final String name, final double maxLatitude,
      final double minLatitude, final double maxLongitude, final double minLongitude) {
    this.id = id;
    this.name = name;
    this.maxLatitude = maxLatitude;
    this.minLatitude = minLatitude;
    this.maxLongitude = maxLongitude;
    this.minLongitude = minLongitude;
  }

  private int id;

  private String name;

  private double maxLatitude;

  private double minLatitude;

  private double maxLongitude;

  private double minLongitude;

  @JsonGetter("id")
  public int getId() {
    return id;
  }

  @JsonGetter("name")
  public String getName() {
    return name;
  }

  @JsonGetter("max-latitude")
  public double getMaxLatitude() {
    return maxLatitude;
  }

  @JsonGetter("min-latitude")
  public double getMinLatitude() {
    return minLatitude;
  }

  @JsonGetter("max-longitude")
  public double getMaxLongitude() {
    return maxLongitude;
  }

  @JsonGetter("min-longitude")
  public double getMinLongitude() {
    return minLongitude;
  }

  public static Builder getBuilder() {
    return new Builder();
  }

  /**
   * Serializes the object to JSON
   *
   * @return a json representation of the object
   */
  public String toJson() {
    try {
      return JsonUtils.INSTANCE.writeObjectAsJsonString(this);
    } catch (final JsonProcessingException exception) {
      // TODO: add log message explaining about this error
      return "";
    }
  }

  public static class Builder {

    private int id = 0;
    private String name = "";
    private double maxLatitude = 0.0;
    private double minLatitude = 0.0;
    private double maxLongitude = 0.0;
    private double minLongitude = 0.0;

    public Builder withId(final int id) {
      this.id = id;

      return this;
    }

    public Builder withName(final String name) {
      this.name = name;

      return this;
    }

    public Builder withMaxLatitude(final double maxLatitude) {
      this.maxLatitude = maxLatitude;

      return this;
    }

    public Builder withMinLatitude(final double minLatitude) {
      this.minLatitude = minLatitude;

      return this;
    }

    public Builder withMaxLongitude(final double maxLongitude) {
      this.maxLongitude = maxLongitude;

      return this;
    }

    public Builder withMinLongitude(final double minLongitude) {
      this.minLongitude = minLongitude;

      return this;
    }

    public Country build() {
      return new Country(this.id, this.name, this.maxLatitude, this.minLatitude, this.maxLongitude,
          this.minLongitude);
    }
  }
}
