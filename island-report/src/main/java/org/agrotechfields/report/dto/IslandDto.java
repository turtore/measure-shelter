package org.agrotechfields.report.dto;

import java.util.ArrayList;
import java.util.List;
import org.agrotechfields.report.model.Measure;

public class IslandDto {

  public String id;

  public String name;
  public boolean active;

  public List<Measure> measures;

  public IslandDto() {
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
  public void setInactive() {
    this.active = false;
  }

  public boolean isActive() {
    return this.active;
  }

  public String getName() {
    return this.name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
