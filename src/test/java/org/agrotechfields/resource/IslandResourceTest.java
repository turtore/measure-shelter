package org.agrotechfields.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.agrotechfields.model.Island;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class IslandResourceTest {

  @Test
  @Order(1)
  @DisplayName("1 - Endpoint should register a new Island")
  public void testCreateIslandEndpoint() {
    Island testIsland = new Island();
    testIsland.setName("Test Island");

    given().contentType("application/json").body(testIsland).when().post("/islands/add").then().statusCode(201);
  }

    @Test
    @Order(2)
    @DisplayName("2 - Endpoint should get a list response")
    public void testGetAllEndpoint() {

      given().when().get("/islands/").then().statusCode(200);
    }

//    @Test
//    @Order(3)
//    @DisplayName("3 - Endpoint should delete after insert a test island")
//    public void testDeleteEndpoint() {
//
//
//      given().when().delete("/islands?name=dontexists").then().statusCode(404);
//    }

}