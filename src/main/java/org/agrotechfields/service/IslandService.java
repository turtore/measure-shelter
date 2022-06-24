package org.agrotechfields.service;

import org.agrotechfields.model.Island;
import org.agrotechfields.model.Measure;
import org.agrotechfields.repository.IslandRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class IslandService {

  @Inject
  IslandRepository islandRepository;


//  @Transactional
  public List<Island> getAll() {
    return islandRepository.listAll();
  }

  @Transactional
  public void addIsland(Island island) {
    islandRepository.persist(island);
  }


  @Transactional
  public void addReport(String name, Measure measureData) {
    Island island = islandRepository.findByName(name);
    Measure measure = new Measure(measureData);
    island.addMeasure(measure);
    islandRepository.update(island);
  }

//  @Transactional
  public Object findByName(String name) {
    return islandRepository.findByName(name);
  }

  public void removeIsland(String name) {
    islandRepository.delete(islandRepository.findByName(name));
  }

  public void removeIslandById(ObjectId id) {
    islandRepository.deleteById(id);
  }
}
