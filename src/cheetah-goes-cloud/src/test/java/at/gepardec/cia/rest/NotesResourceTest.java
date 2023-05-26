package at.gepardec.cia.rest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class NotesResourceTest {

    @Test
    public void testFindAllNotesEmpty() {
        given()
                .when().get("/notes")
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

}