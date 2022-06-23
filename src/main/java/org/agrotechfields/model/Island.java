package org.agrotechfields.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

@MongoEntity(collection = "measureshelter")
public class Island extends PanacheMongoEntity {
    public String name;
    public boolean active;

    public List<Measure> measures;

    public Island() {

    }

}
