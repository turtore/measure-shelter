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

}