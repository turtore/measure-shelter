package org.agrotechfields.service;

import org.agrotechfields.exception.EmptyNameException;
import org.agrotechfields.exception.InactiveIslandException;
import org.agrotechfields.exception.NameNotFoundException;
import org.agrotechfields.model.Island;
import org.agrotechfields.model.Measure;
import org.agrotechfields.repository.IslandRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import java.util.List;

@ApplicationScoped
public class IslandService {

  @Inject
  IslandRepository islandRepository;



  public List<Island> getAll() {
    return islandRepository.listAll();
  }


  public void addIsland(Island island) {
    if (island.name.trim().equals("") || island.name == null) {
      throw new EmptyNameException("Name cannot be blank");
    } else {
      island.setActive();
      islandRepository.persist(island);
    }
  }


  public void addReport(String name, Measure measureData) {
    if (islandRepository.existsByName(name)) {
      Island island = islandRepository.findByName(name);
      if (island.isActive()){
        Measure measure = new Measure(measureData);
        island.addMeasure(measure);
        islandRepository.update(island);
      } else {
        throw new InactiveIslandException("Island " + island.getName() + " status is Inactive!");
      }
    } else {
      throw new NameNotFoundException("Island Not Found");
    }
  }


  public Object findByName(String name) {
    return islandRepository.findByName(name);
  }


  public void removeIslandByName(String name) {
    if (islandRepository.existsByName(name)) {
      islandRepository.delete(islandRepository.findByName(name));
    } else {
      throw new NameNotFoundException("No island found with the Name provided");
    }
  }


  public void removeIslandById(ObjectId id) {
    islandRepository.deleteById(id);
  }
}
