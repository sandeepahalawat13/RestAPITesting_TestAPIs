package com.restassuredapitesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_CompleteResponseValidation {

	@Test
	void ValidateCompleteResponseBody(){
		
		//Specify base URI
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET, "/Delhi");
		
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//Capture the JSON response
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDifectionDegree"));
		
		
		
		}
}
