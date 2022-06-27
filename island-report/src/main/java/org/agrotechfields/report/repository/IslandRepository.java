package org.agrotechfields.report.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.agrotechfields.report.model.Island;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {

  public Island findByName(String name) {
    return find("name", name).firstResult();
  }
  public boolean existsByName(String name) {
    return find("name", name).count() > 0;
  }

}
