package org.agrotechfields.report.service;

import io.quarkus.runtime.util.StringUtil;
import java.util.Optional;
import org.agrotechfields.report.dto.IslandDto;
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
    if (island.getName() == null || island.getName().trim().equals("")) {
      throw new EmptyNameException();
    } else {
      island.setActive();
      islandRepository.persist(island);
    }
  }


  public void addReport(ObjectId id, Measure measureData) {
    if (islandRepository.existsById(id)) {
      Island island = islandRepository.findById(id);
      if (island.isActive()){
        Measure measure = new Measure(measureData);
        island.addMeasure(measure);
        islandRepository.update(island);
      } else {
        throw new InactiveIslandException();
      }
    } else {
      throw new NameNotFoundException();
    }
  }



  public void removeIslandById(ObjectId id) {
    if (islandRepository.findById(id) != null) {
      islandRepository.deleteById(id);
    } else {
      throw new IdNotFoundException();
    }
  }


  public void turnActive(ObjectId id) {
    if(islandRepository.existsById(id)) {
      Island island = islandRepository.findById(id);
      island.setActive();
      island.update(island);
    } else {
      throw new NameNotFoundException();
    }
  }


  public void turnInactive(ObjectId id) {
    if(islandRepository.existsById(id)) {
      Island island = islandRepository.findById(id);
      island.setInactive();
      island.update(island);
    } else {
      throw new NameNotFoundException();
    }
  }

  public Island editIsland(String id, IslandDto islandDto) {
    Island island = new Island();
    island.setName(islandDto.getName());
    island.setMeasures(islandDto.getMeasures());
    island.setId(new ObjectId(id));

    islandRepository.update(island);

    return island;
  }

  public Island findById(ObjectId objectId) {
    return Optional.ofNullable(islandRepository
        .findById(objectId))
        .orElseThrow(() -> new  IdNotFoundException());
  }
}
