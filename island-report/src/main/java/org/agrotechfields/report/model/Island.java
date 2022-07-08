package org.agrotechfields.report.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "measureshelter")
public class Island extends PanacheMongoEntity {


  private String name;
  private boolean active;

  public List<Measure> measures;


  public Island() {
    this.measures = new ArrayList<>();
  }

  public void addMeasure(Measure measure) {
    measures.add(measure);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setActive() {
    this.active = true;
  }
  public void setInactive() {
    this.active = false;
  }

  public boolean isActive() {
    return this.active;
  }

  public String getName() {
    return this.name;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public List<Measure> getMeasures() {
    return measures;
  }

  public void setMeasures(List<Measure> measures) {
    this.measures = measures;
  }
}
