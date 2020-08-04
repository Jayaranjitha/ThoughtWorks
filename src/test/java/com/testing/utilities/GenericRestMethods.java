package com.testing.utilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GenericRestMethods {
	
		
   public  static Response post(String URL,String jsonBody) {
			
	  final Response resp = given().auth().preemptive().basic("dradmin","87cbe99dbff6a962f333710b57cec9c8").contentType("application/json").body(jsonBody).when().post(URL)
					.then().statusCode(200)
					.extract()
					.response();
					

			System.out.println("StatusCode" + resp.getBody());
	       
			System.out.println("StatusCode" + resp.getStatusCode());
	       
			
			return resp;
			
		}
		
         public static Response get(String url) {
			
        	   RestAssured.baseURI = "https://iotimpactstg.starhub.com";
        	   RestAssured.authentication = preemptive().basic("dradmin","87cbe99dbff6a962f333710b57cec9c8");
			  
        	 
        	 final Response resp1 = given().contentType("application/json").
			when().queryParam("type", "lifeCycleEvents").queryParam("groupName", "TC4_1_4").get(url)
			.then()
		//	 .body("subscriptions.subscriptionId",equalTo("0b26bc20-1d71-4758-a9ad-75f9b221e404"))
			 .statusCode(200)
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
         
//         public static void main(String[] args) throws Throwable {
//				
//     		 
//     		Response resp1= GenericRestMethods.post("dfasd", "asdfsd");
//     		
//     		System.out.println("daf" +resp1.getBody());
//     		
//         }
         

	}


