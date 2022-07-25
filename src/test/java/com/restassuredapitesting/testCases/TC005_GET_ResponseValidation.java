package com.restassuredapitesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ResponseValidation {

	@Test
	void ValidateResponseBody(){
		
		//Specify base URI
		RestAssured.baseURI= "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET, "/Delhi");
		
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//Response body validation
		Assert.assertEquals(responseBody.contains("Delhi"), true);
		
		}
}
