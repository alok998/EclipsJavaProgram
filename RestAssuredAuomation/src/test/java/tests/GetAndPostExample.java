package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExample {
	
	//@Test
	public void Gettest() {
		
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[0].first_name",equalTo("Michael")).
		body("data.first_name",hasItems("George","Rachel"));
		
	}
	@Test
	public void testPost() {
		Map<String, Object>map =new HashMap<String, Object>();
		//map.put("name","raghav");
		//map.put("job","Teaching");
		//System.out.println(map);
		
		JSONObject request =new JSONObject(map);
		request.put("name","Raghav");
		request.put("job","Teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
		header("Content-Type","application").
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201)
		.log().all();
		
	}

}
