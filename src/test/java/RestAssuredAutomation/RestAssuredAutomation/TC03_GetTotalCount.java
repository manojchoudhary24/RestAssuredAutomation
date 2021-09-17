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

public class TC03_GetTotalCount {

	//Verify total number of people checked
	
	@Test
	void getpeopleDetails(){
		
		//Specify base URI
		
		RestAssured.baseURI="https://swapi.dev/api/people/";
		
		//Request Object
		RequestSpecification httprequest= RestAssured.given();
		
		//Response object
		int j=1;
		
		for(int i=1; i<=100; i++) {
			
			try {
		
		Response response=httprequest.request(Method.GET,String.valueOf(i));
		
		String responseBody=response.getBody().asString();
		
		String heights = response.jsonPath().getString("height");

		
		if (Integer.parseInt(heights)!=0) {
			j++;
		}
		
	} catch(Exception e){
		//System.err.println("An exception was thrown");
								
	}
}
		System.out.println("\n"+"Count :"+j);
		
			
	}
}
