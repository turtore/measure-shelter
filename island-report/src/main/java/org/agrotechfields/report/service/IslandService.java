package org.agrotechfields.report.service;

import org.agrotechfields.report.exception.EmptyNameException;
import org.agrotechfields.report.exception.IdNotFoundException;
import org.agrotechfields.report.exception.InactiveIslandException;
import org.agrotechfields.report.exception.NameNotFoundException;
import org.agrotechfields.report.model.Island;
import org.agrotechfields.report.model.Measure;
import org.agrotechfields.report.repository.IslandRepository;
import org.bson.types.ObjectId;

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
      throw new NameNotFoundException("No island found with the Name= " + name);
    }
  }


  public void removeIslandById(ObjectId id) {
    if (islandRepository.findById(id) != null) {
      islandRepository.deleteById(id);
    } else {
      throw new IdNotFoundException("Island with Id= "+ id +" not found");
    }
  }

  public void turnActive(String name) {
    if(islandRepository.existsByName(name)) {
      Island island = islandRepository.findByName(name);
      island.setActive();
      island.update(island);
    } else {
      throw new NameNotFoundException("No island found");
    }
  }

  public void turnInactive(String name) {
    if(islandRepository.existsByName(name)) {
      Island island = islandRepository.findByName(name);
      island.setInactive();
      island.update(island);
    } else {
      throw new NameNotFoundException("No island found");
    }
  }
}
