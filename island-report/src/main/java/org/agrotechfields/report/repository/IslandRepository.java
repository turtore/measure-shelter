package org.agrotechfields.report.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.agrotechfields.report.model.Island;

import javax.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {

  public boolean existsById(ObjectId id) {
    return find("id", id).count() > 0;
  }
}
