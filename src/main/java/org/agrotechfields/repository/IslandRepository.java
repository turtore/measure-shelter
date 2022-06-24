package org.agrotechfields.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.agrotechfields.model.Island;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {

  public Island findByName(String name) {
    return find("name", name).firstResult();
  }
  public boolean existsByName(String name) {
    return find("name", name).count() > 0;
  }
  public boolean existsById(ObjectId id) {
    return find("id", id).count() > 0;
  }
}
