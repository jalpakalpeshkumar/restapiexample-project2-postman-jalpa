package com.restapiexample.dummy.restapiexampleinfo;

import com.restapiexample.dummy.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class EmployeePutTest extends TestBase {

    @Test
    public void testUpdateEmployee() {
        // Test PUT request to update an employee
        String updatedEmployeeData = "{ \"name\": \"John Doe\", \"salary\": \"55000\", \"age\": \"31\" }";

        given()
                .header("Content-Type", "application/json")
                .body(updatedEmployeeData)
                .when()
                .put("/update/1")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", equalTo("Successfully! Record has been updated."));
    }

}
