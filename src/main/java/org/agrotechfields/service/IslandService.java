package org.agrotechfields.service;

import org.agrotechfields.model.Island;
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


}
