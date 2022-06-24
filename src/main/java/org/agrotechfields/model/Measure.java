package org.agrotechfields.model;

import java.time.LocalDateTime;

public class Measure {
  public LocalDateTime moment;

  public Integer temperature;
  public Integer airHumidity;
  public Integer soilMoisture;


  public Measure() {
  }

  public Measure(Measure measureData) {
    LocalDateTime moment = LocalDateTime.now();
    this.moment = moment;
    this.temperature = measureData.temperature;
    this.airHumidity = measureData.airHumidity;
    this.soilMoisture = measureData.soilMoisture;
  }
}
