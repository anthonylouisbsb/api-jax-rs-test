package me.anthonylouis.server.entity;

public class Country {

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
}
