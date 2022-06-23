package org.agrotechfields.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "measureshelter")
public class Island extends PanacheMongoEntity {
    public String name;
    public Integer temperature;
    public Integer airHumidity;
    public Integer soilMoisture;

    public Island() {

    }

    public Island(String name, Integer temperature, Integer airHumidity, Integer soilMoisture) {
        this.name = name;
        this.temperature = temperature;
        this.airHumidity = airHumidity;
        this.soilMoisture = soilMoisture;
    }
}
