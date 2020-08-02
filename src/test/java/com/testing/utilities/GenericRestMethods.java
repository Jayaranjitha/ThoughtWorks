package com.testing.utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GenericRestMethods {
	
		
   public  static Response post(String URL,String jsonBody) {
			
	        
	   System.out.println("StatusCode1" + URL);
	   
			final Response resp = given().auth().basic("dradmin","87cbe99dbff6a962f333710b57cec9c8").contentType("application/json").body(jsonBody).when().post(URL)
					.then().statusCode(200)
					.extract()
					.response();

			System.out.println("StatusCode" + resp);
	       
			System.out.println("StatusCode" + resp.getStatusCode());
	       
			
			return resp;
			
		}
		
         public static Response get(String Geturl) {
			
			final Response resp1 = given().auth().basic("user.qa1","userqa1!").contentType("application/json").when().get(Geturl)
			.then().statusCode(200)
			.extract()
			.response();
			
			return resp1;
			
		}
         
         public static Response put(String Puturl, String response) {
        	 final Response putresp = given().auth().basic("user.qa1","userqa1!").contentType("application/json").body(response).when().put(Puturl)
     				.then().statusCode(200)
     				.extract()
     				.response();
        	 return putresp;

         }

	}


