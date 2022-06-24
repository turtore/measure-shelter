package org.agrotechfields.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.ArrayList;
import java.util.List;

@MongoEntity(collection = "measureshelter")
public class Island extends PanacheMongoEntity {
  public String name;
  public boolean active;

  public List<Measure> measures;

  public Island() {
    this.measures = new ArrayList<>();
  }

  public void addMeasure(Measure measure) {
    if ((this.measures).equals(null)) {
      this.measures = new ArrayList<>();
    }
    measures.add(measure);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setActive() {
    this.active = true;
  }
}
