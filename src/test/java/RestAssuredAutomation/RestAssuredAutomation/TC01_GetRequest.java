package RestAssuredAutomation.RestAssuredAutomation;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import groovyjarjarantlr.ParserSharedInputState;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_GetRequest {
	
	//Verify that the people end point is returning a successful response
	
	@Test
	void getpeopleDetails(){
		
		//Specify base URI
		
		RestAssured.baseURI="https://swapi.dev/api/people/";
		
		//Request Object
		RequestSpecification httprequest= RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/1");
			
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response body is :"+responseBody);
		
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("StatusCode is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		//Status line verification
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is :"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");  
		
	}
}
