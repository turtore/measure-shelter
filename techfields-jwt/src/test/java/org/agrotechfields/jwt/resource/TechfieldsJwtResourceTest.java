package org.agrotechfields.jwt.resource;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@QuarkusTest
class TechfieldsJwtResourceTest {

  @Test
  @Order(1)
  @DisplayName("1 - Endpoint should produce a access token for admin")
  void getJwt() {

    given().contentType("application/json").when().get("/jwt").then().statusCode(200);
  }
}