package com.restassuredapitesting.testCases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassuredapitesting.utilties.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_DDT_AddNewEmployees {
	
	@Test(dataProvider = "empdataprovider")
	void PostNewEmployees(String ename, String esalary, String eage) {
		
	
				//Specify base URI
				RestAssured.baseURI= "https://dummy.restapiexample.com/api/v1";
				
				//Request object
				RequestSpecification httprequest = RestAssured.given();
				
				//Request Payload
				JSONObject requestParams = new JSONObject();
				requestParams.put("Name", ename);
				System.out.println(ename);
				requestParams.put("Salary", esalary);
				System.out.println(esalary);
				requestParams.put("Age", eage);
				System.out.println(eage);
								
				//Header details needs to be passed along with the request
				httprequest.header("Content-Type","application/json");
				httprequest.body(requestParams.toJSONString());
				
				//Response Object
				Response response = httprequest.request(Method.POST, "/create");
				
				//Print response in console
				String responseBody = response.getBody().asString();
//				System.out.println("Response body is:"+ responseBody);
				
				//Verification of response
				Assert.assertEquals(responseBody.contains(ename), true);
				Assert.assertEquals(responseBody.contains(esalary), true);
				Assert.assertEquals(responseBody.contains(eage), true);
				
				//Status code validation
				int statusCode = response.getStatusCode();
				Assert.assertEquals(statusCode, 200);
				
				
	}
	
		
	@DataProvider(name="empdataprovider")
	String[][] getEmpData() throws IOException{
		
		
		//Read data from Excel and pass to 2D array
		String path = System.getProperty("user.dir")+"/src/test/java/com/restassuredapitesting/testData/EmpData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String empData[][] =  new String[rowcount][colcount];
		for(int i=1; i<=rowcount; i++) {
			for(int j=0; j<colcount; j++) {
				empData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return(empData);
	}
}
