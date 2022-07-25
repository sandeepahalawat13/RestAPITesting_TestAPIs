package com.restassuredapitesting.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_RegistrationSuccessful {
	
	@Test
	void RegistrationSuccessful(){
		
		//Specify base URI
		RestAssured.baseURI= "http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request Payload
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Sandeep");
		requestParams.put("LastName", "Ahalawat");
		requestParams.put("UserName", "Sandeep.Ahalawat");
		requestParams.put("Password", "Sandy@1314");
		requestParams.put("Email", "sandeepahalawat@gmail.com");
		
		//Header details needs to be passed along with the request
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httprequest.request(Method.POST, "/register");
		
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		//Success code validation
		String successcode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
	}

}
