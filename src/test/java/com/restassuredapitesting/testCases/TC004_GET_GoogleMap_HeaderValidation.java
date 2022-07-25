package com.restassuredapitesting.testCases;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_GoogleMap_HeaderValidation {

	@Test
	void googleMapTest(){
		
		//Specify base URI
		RestAssured.baseURI= "http://maps.googleapis.com";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//Print all headers
		Headers allHeaders = response.headers(); // Returns in Map
		
		for(Header header : allHeaders) {
			System.out.println(header.getName()+"   "+header.getValue());
		}
		}
}
