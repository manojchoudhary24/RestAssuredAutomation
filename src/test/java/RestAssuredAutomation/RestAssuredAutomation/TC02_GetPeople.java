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

public class TC02_GetPeople {

	//Verify that the total number of people where height is greater than 200
	//Verify the individuals name
	
	@Test
	void getpeopleDetails(){
		
		//Specify base URI
		
		RestAssured.baseURI="https://swapi.dev/api/people/";
		
		//Request Object
		RequestSpecification httprequest= RestAssured.given();
		
		//Response object
		int j=0;
		
		for(int i=1; i<=83; i++) {
			
			try {
		
		Response response=httprequest.request(Method.GET,String.valueOf(i));
		
		String responseBody=response.getBody().asString();
		
		String heights = response.jsonPath().getString("height");

		
		if (Integer.parseInt(heights) > 200) {
			String names= response.jsonPath().getString("name");
			System.out.print(names+",");
			j++;
		}
		
	} catch(Exception e){
		//System.err.println("An exception was thrown");
								
	}
}
		System.out.println("\n"+"Total Number of people :"+j);
		
	//	List<String> jsonResponse = response.jsonPath().getList("height");
	//	System.out.println(jsonResponse.get(0));
		
	/*	
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("StatusCode is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		//Status line verification
		String statusLine=response.getStatusLine();
		System.out.println("StatusLine is :"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");  */
		
	}
}
