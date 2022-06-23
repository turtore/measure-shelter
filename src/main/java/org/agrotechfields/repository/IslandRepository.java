package org.agrotechfields.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.agrotechfields.model.Island;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IslandRepository implements PanacheMongoRepository<Island> {
}
