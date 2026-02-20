package org.acme.getting.started.testing;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class TicketResourceTest {

    @Test
    public void testShowTicket1() {
        given()
                .when().get("tickets/{id}", 1L)
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("text", is("Saha ftorek !"))
                .body("date", startsWith("2026-02-18"));
    }

    @Test
    public void testShowTicket2() {
        given()
                .when().get("tickets/{id}", 2L)
                .then()
                .statusCode(200)
                .body("id", is(2))
                .body("text", is("Ramadan mubarak !"))
                .body("date", startsWith("2026-02-18"));
    }

    @Test
    public void deleteTicket() {
        given()
                .when().delete("/tickets/{id}", 1L)
                .then()
                .statusCode(204);
    }
}