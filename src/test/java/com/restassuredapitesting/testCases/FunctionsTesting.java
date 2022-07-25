package com.restassuredapitesting.testCases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FunctionsTesting {
	
	
	@Test
	public void LearningFunctions() {
		
		given()
		.when()
			.delete("")
			.then()
			.statusCode(200);
	}

}
