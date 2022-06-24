package org.agrotechfields.service;

import org.agrotechfields.model.Island;
import org.agrotechfields.model.Measure;
import org.agrotechfields.repository.IslandRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class IslandService {

  @Inject
  IslandRepository islandRepository;


  public List<Island> getAll() {
    return islandRepository.listAll();
  }

  public void addIsland(Island island) {
    islandRepository.persist(island);
  }


  public void addReport(String name, Measure measureData) {
    Island island = islandRepository.findByName(name);
    Measure measure = new Measure(measureData);
    island.addMeasure(measure);
    islandRepository.update(island);
  }

  public Object findByName(String name) {
    return islandRepository.findByName(name);
  }
}
