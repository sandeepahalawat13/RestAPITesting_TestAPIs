package com.restassuredapitesting.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_AuthenticationAPI {
	
	@Test
	void AuthorizationTest() {
		
				//Specify base URI
				RestAssured.baseURI= "http://restapi.demoqa.com/authentication/CheckForAuthentication";
				
				//Basic Authentication
				PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
				authscheme.setUserName("ToolsQA");
				authscheme.setPassword("TestPassword");
				RestAssured.authentication = authscheme;
				
				//Request object
				RequestSpecification httprequest = RestAssured.given();
				
				//Response object
				Response response = httprequest.request(Method.GET, "/");
				
				//Status code validation
				int statusCode = response.getStatusCode();
				Assert.assertEquals(statusCode, 200);
				
				//Print response in console
				String responseBody = response.getBody().asString();
				System.out.println("Response body is:"+responseBody);
		
	}

}
