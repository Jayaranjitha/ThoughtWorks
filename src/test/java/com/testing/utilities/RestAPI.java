package com.testing.utilities;



import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.methods.java.WEB_Methods;

public class RestAPI {
	
	private String id;
	private String stepid;
	private String signal;
	private String response;
	private String responsebody;
	public WEB_Methods webmethods = new WEB_Methods(); 
	public GenericRestMethods genRest = new  GenericRestMethods();
	
	
	public String postAPI() throws Exception {
			
			String jsonBody = webmethods.jsonData("Subscriptions.json");
			String url = "https://iotimpactstg.starhub.com/m2m/subscriptions?type=lifeCycleEvents";
			System.out.println("URL" +url);
			 Response resp = GenericRestMethods.post(url,jsonBody);
			    responsebody= resp.asString();
			        JSONObject jsonObj = new JSONObject(responsebody);
			    	JSONArray jsonarray = jsonObj.getJSONArray("0");
			         id = jsonObj.getString("deletionPolicy");
			        System.out.println(id);
			        return id;
		}
			    
		public void getAPI() throws Exception {
						
			String url = "https://iotimpactstg.starhub.com/m2m/subscriptions?type=lifeCycleEvents";
			
			Response resp1 = GenericRestMethods.get(url);
	
			System.out.println("StatusCode" + resp1.getStatusCode());
			
			System.out.println("Response Body" + resp1.getBody().asString());
			JSONObject jsonobj1= new JSONObject(resp1.asString());
			JSONArray jsonarray = jsonobj1.getJSONArray("validSignals");
		    JSONObject test = jsonarray.getJSONObject(3);
			signal = test.getString("name");
			System.out.println(signal);
			
			
			
			JSONObject jsonobj2= new JSONObject(resp1.asString()).getJSONObject("info");
			stepid = jsonobj2.getString("stepID");
			System.out.println(stepid);
			
			
			
			
			}
		
	    
	    public void putAPI() throws Exception {
		
	            String Puturl = "http://135.115.145.180:8081/wfe/rest/5.2/instances/" + id + "/step/" + stepid;
	            System.out.println(Puturl);
	            Response putresp = GenericRestMethods.put(Puturl, response);
	            System.out.println("StatusCode" + putresp.getStatusCode());
				System.out.println("Response Body" + putresp.getBody().asString());
	             responsebody= putresp.asString();
		        String jsonObj = new JSONObject(responsebody).getString("templateName");
		         id = jsonObj.toString();
		        System.out.println(id);
		        
		        for (int i = 0; i < 10;i++ ) {
		        	
		        	Response putresp1 = GenericRestMethods.put(Puturl, response);
		        	System.out.println("Response Body" + putresp1.getBody().asString());
		        	responsebody= putresp1.asString();
			        String jsonObj1 = new JSONObject(responsebody).getString("templateName");
			         id = jsonObj1.toString();
			        System.out.println(id);
	        
	        if(!id.equalsIgnoreCase("wait")) {
	        	break;
	        }
	        
		        }
		        
		        
	        	
	        }
	                
			
		public static void main(String[] args) throws Throwable {
				
			 RestAPI r = new RestAPI();
			 String id = r.postAPI();
	
	         System.out.println(id);
	
	
		
		}
	

}
