package org.agrotechfields.report.service;

import java.util.Optional;
import org.agrotechfields.report.dto.IslandDto;
import org.agrotechfields.report.exception.EmptyNameException;
import org.agrotechfields.report.exception.IdNotFoundException;
import org.agrotechfields.report.exception.InactiveIslandException;
import org.agrotechfields.report.exception.NameNotFoundException;
import org.agrotechfields.report.model.Island;
import org.agrotechfields.report.model.Measure;
import org.agrotechfields.report.repository.IslandRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import org.bson.types.ObjectId;

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


  public void addReport(String id, Measure measureData) {
    Island island = islandRepository.findById(new ObjectId(id));
    if (island == null) {
      throw new NameNotFoundException();
    } else if (island.isActive()){
      Measure measure = new Measure(measureData);
      island.addMeasure(measure);
      islandRepository.update(island);
    } else {
      throw new InactiveIslandException();
    }
  }


  public void removeIslandById(String id) {
    if (islandRepository.existsById(id)) {
      Island island = islandRepository.findById(new ObjectId(id));
      islandRepository.delete(island);
    } else {
      throw new IdNotFoundException();
    }
  }


  public void turnActive(String id) {
    if (!islandRepository.existsById(id)) {
      throw new NameNotFoundException();
    }
    Island island = islandRepository.findById(new ObjectId(id));
    island.setActive();
    island.update(island);
  }


  public void turnInactive(String id) {
    if(islandRepository.existsById(id)) {
      Island island = islandRepository.findById(new ObjectId(id));
      island.setInactive();
      island.update(island);
    } else {
      throw new NameNotFoundException();
    }
  }

  public Island editIsland(String id, IslandDto islandDto) {
    Island island = islandRepository.findById(new ObjectId(id));
    island.setName(islandDto.getName());
    island.setMeasures(islandDto.getMeasures());

    islandRepository.update(island);

    return island;
  }

  public Island findById(String id) {
    return islandRepository.findById(new ObjectId(id));
//    return Optional.ofNullable(islandRepository
//        .findById(objectId))
//        .orElseThrow(() -> new  IdNotFoundException());
  }
}
