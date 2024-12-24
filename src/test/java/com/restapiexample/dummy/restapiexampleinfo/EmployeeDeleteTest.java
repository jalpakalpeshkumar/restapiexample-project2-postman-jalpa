package com.restapiexample.dummy.restapiexampleinfo;

import com.restapiexample.dummy.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeDeleteTest extends TestBase {

    @Test
    public void testDeleteEmployee() {
        // Test DELETE request to delete an employee
        given()
                .when()
                .delete("/delete/1")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been deleted."));
    }
}
