package org.agrotechfields.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.agrotechfields.model.Measure;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeasureRepository implements PanacheMongoRepository<Measure> {
}
