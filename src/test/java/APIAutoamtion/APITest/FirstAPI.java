package APIAutoamtion.APITest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class FirstAPI {

	
	@Description("This s the first API test")
	@Story("API Test to validate the status code and body response")
	@Test
	public void TestAPI() {

		given()
			.baseUri("https://rahulshettyacademy.com")
			.queryParam("Key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(Payload.bodymessage()).
		when()
			.post("maps/api/place/add/json").
		then()
			.log().all()
			.statusCode(200)
			.body("scope", equalTo("APP"))
			.body("status", equalTo("OK"))
			.header("Content-Type",equalTo("application/json;charset=UTF-8"))
			.statusLine("HTTP/1.1 200 OK");
			
	}
}
