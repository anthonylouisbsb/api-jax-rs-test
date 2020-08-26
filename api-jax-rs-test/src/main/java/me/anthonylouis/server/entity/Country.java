package me.anthonylouis.server.entity;

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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public double getMaxLatitude() {
    return maxLatitude;
  }

  public void setMaxLatitude(final double maxLatitude) {
    this.maxLatitude = maxLatitude;
  }

  public double getMinLatitude() {
    return minLatitude;
  }

  public void setMinLatitude(final double minLatitude) {
    this.minLatitude = minLatitude;
  }

  public double getMaxLongitude() {
    return maxLongitude;
  }

  public void setMaxLongitude(final double maxLongitude) {
    this.maxLongitude = maxLongitude;
  }

  public double getMinLongitude() {
    return minLongitude;
  }

  public void setMinLongitude(final double minLongitude) {
    this.minLongitude = minLongitude;
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
