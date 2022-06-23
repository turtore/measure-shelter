package org.agrotechfields.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "islands")
public class Island extends PanacheMongoEntity {
    public String name;
    public Integer temperature;
    public Integer airHumidity;
    public Integer soilMoisture;
}
