package com.restapiexample.dummy.restapiexampleinfo;

import com.restapiexample.dummy.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmployeePostTest extends TestBase {

    @Test
    public void testCreateEmployee() {
        // Test POST request to create a new employee
        String newEmployeeData = "{ \"name\": \"John Doe\", \"salary\": \"50000\", \"age\": \"30\" }";

        given()
                .header("Content-Type", "application/json")
                .body(newEmployeeData)
                .when()
                .post("/create")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been added."));
    }
}
