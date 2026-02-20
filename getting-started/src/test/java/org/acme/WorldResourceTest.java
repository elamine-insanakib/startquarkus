package org.acme.getting.started.testing;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class WorldResourceTest {

    @Test
    public void testOtherRoute() {
        given()
                .when().get("world/other")
                .then()
                .statusCode(200)
                .body(is("A world isn't possible..."));
    }
}