package com.restassuredapitesting.testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_WeatherDetails {
	
	@Test
	void getWeatherDetails(){
		
		//Specify base URI
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET, "/Hyderabad");
		
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		//Status line verification
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
}
