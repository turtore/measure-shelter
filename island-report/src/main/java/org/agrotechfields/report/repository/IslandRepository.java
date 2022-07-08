package org.agrotechfields.report.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import java.util.Optional;
import org.agrotechfields.report.model.Island;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {

  public boolean existsById(String id) {
    return find("id", id).count() > 0;
  }
}
