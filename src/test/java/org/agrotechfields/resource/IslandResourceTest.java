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
  @DisplayName("2 - Endpoint should deny register a blank name new Island")
  public void testNoNameCreateIslandEndpoint() {
    Island testIsland = new Island();
    testIsland.setName("");
    given().contentType("application/json").body(testIsland).when().post("/islands/add").then().statusCode(400);
  }

    @Test
    @Order(3)
    @DisplayName("3 - Endpoint GET all islands should return a list response")
    public void testGetAllEndpoint() {

      given().when().get("/islands/").then().statusCode(200);
    }

    @Test
    @Order(4)
    @DisplayName("4 - Should return notFound(404) if asked to delete a island that doesn't exists")
    public void testNotFoundDeleteEndpoint() {


      given().when().delete("/islands?name=dontexists").then().statusCode(404);
    }

}