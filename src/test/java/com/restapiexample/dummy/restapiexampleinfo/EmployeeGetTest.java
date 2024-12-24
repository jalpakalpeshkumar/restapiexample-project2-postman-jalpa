package com.restapiexample.dummy.restapiexampleinfo;

import com.restapiexample.dummy.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EmployeeGetTest extends TestBase {

    @Test
            public void testGetAllEmployees(){
    Response response = given()
            .when()
            .get("/employees")
            .then()
            .statusCode(200)  // Verify that the status code is 200
            .extract().response();

    // Verify the following conditions
    int totalRecords = response.jsonPath().getInt("total");
        assert totalRecords == 24 : "Total records should be 24";


        int lastEmployeeId = response.jsonPath().getInt("data[23].id");
        assert lastEmployeeId == 24 : "The last employee's id should be 24";

    String employeeName = response.jsonPath().getString("data[23].employee_name");
        assert employeeName.equals("Doris Wilder") : "Employee name should be 'Doris Wilder'";

    String message = response.jsonPath().getString("message");
        assert message.equals("Successfully! All records has been fetched.") : "Message should match the expected one";

    String status = response.jsonPath().getString("status");
        assert status.equals("success") : "Status should be 'success'";

    int salary = response.jsonPath().getInt("data[3].employee_salary");
        assert salary == 86000 : "Employee with id 3 should have salary 86000";

    int age = response.jsonPath().getInt("data[6].employee_age");
        assert age == 61 : "Employee with id 6 should have age 61";

    String nameAtId11 = response.jsonPath().getString("data[11].employee_name");
        assert nameAtId11.equals("Jena Gaines") : "Employee with id 11 should have name 'Jena Gaines'";
}

    @Test
    public void testGetEmployeeById() {
        // Test GET request for a single employee by ID
        given()
                .when()
                .get("/employee/1")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(1))  // Verify employee with ID 1
                .body("data.employee_name", equalTo("Susan"));
    }
}
