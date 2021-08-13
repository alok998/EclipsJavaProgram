package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExamples {
	
	
	@Test
	public void  test_1(){
		
		
		
		Response responce=RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(responce.getStatusCode());
		System.out.println(responce.getTime());
		System.out.println(responce.getBody().asString());
		System.out.println(responce.getStatusLine());
		System.out.println(responce.getHeader("content-type"));
		
		
		
	}

}
