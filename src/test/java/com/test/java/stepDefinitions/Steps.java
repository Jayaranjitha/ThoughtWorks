package com.test.java.stepDefinitions;		

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.methods.java.WEB_Methods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Steps extends WEB_Methods  {				

    private static final Logger logger = LoggerFactory.getLogger(WEB_Methods.class);
   
    
    
    @Given("^user is already on Login Page$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
    	
    	try {
			
    		 driver=initialization(driver, WEB_getPropertyValue("browserName"),WEB_getPropertyValue("lang"), WEB_getPropertyValue("loginURL"));
    		  System.out.println("browsername" +WEB_getPropertyValue("browserName"));
    			driver.manage().deleteAllCookies();
    			driver.manage().window().maximize();
    			reportGetScreenShot("Login_Page");
    			
    	}
    		catch (Exception e) {
    			e.printStackTrace();
    			System.out.println(e);
    		}
    }	

    @Then("^user enters user name and password$")
	public void user_enters_username_and_password() throws Exception {
    	
    	Thread.sleep(3000);
    	WEB_SendKeys(WEB_Methods.WEB_findElement("NAME", "UserName_textbox"),WEB_getPropertyValue("username"));
		WEB_SendKeys(WEB_Methods.WEB_findElement("NAME", "Password_textbox"),WEB_getPropertyValue("password"));
		captchaMethod(WEB_getPropertyValue("capchatext"),WEB_getPropertyValue("capchatextbox"));
			
	}
   
    @Then("^user verifies the Page Title$")
    
	public void title_of_login_page_is_CSC()throws Exception{

		String title = driver.getTitle();
		if(title.equalsIgnoreCase(WEB_Methods.WEB_getPropertyValue("title")))
			logger.info("Web Portal is logged in successfully");
		else
			logger.info("Web Portal is not logged in successfully");
	}

    
    
    @Then("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_login_button(String button) throws Exception{

		WEB_click(WEB_Methods.WEB_findElement("XPATH", button+"_button"));

		
	}
    
    @Then("^user clicks on logoff button$")
	public void user_Click_on_log_off() throws Throwable {
		WEB_click(WEB_Methods.WEB_findElement("ID", "logoff_button"));
		logger.info("User Logged off successfully");
		driver.quit();
	}
    
    @Then("^user clicks on Search box and enter the search value as \"([^\"]*)\"$")
 	public void user_clicks_on_searchBx(String searchValue) throws Exception{
       
    	logger.info("User Logged in is ---- "+WEB_getPropertyValue("username"));
 		WEB_click(WEB_Methods.WEB_findElement("ID", "search_box"));
 		WEB_SendKeys(WEB_Methods.WEB_findElement("NAME", "search_box"),searchValue);
 	
 	}
    
    @Then("^user add the \"(\\d+)\" item from C to the cart$")
    public void addItem(int searchValue) throws Exception{
       
    	for(int i =0;i < searchValue;i++) {
    
 		WEB_click(WEB_Methods.WEB_findElement("XPATH", "ITEMCOUNT"));
 	
    	}
 	}
    
    @Then("^user validates the Cart Details Information$")
    public void cartDetailsInformation() throws Exception {
    	reportGetScreenShot("Cart Details Page");
    	Assert.assertEquals("ProductName",(WEB_Methods.WEB_findElement("XPATH", "ProductName").getText()),"C");
    	Assert.assertEquals("ProductName",(WEB_Methods.WEB_findElement("XPATH", "ProductPrice").getText()),"100");
    }
    
    
    @Then("^user enters the Payment Details Information$")
    public void paymentDetails() throws Exception {
    	reportGetScreenShot("Payment Details Page");
    	WEB_SendKeys(WEB_Methods.WEB_findElement("ID", "Payment_NAMETAG"),WEB_getPropertyValue("Payment_NAME"));
    	WEB_SendKeys(WEB_Methods.WEB_findElement("ID", "Payment_MOBILETAG"),WEB_getPropertyValue("Payment_MOBILE"));
    	WEB_SendKeys(WEB_Methods.WEB_findElement("ID", "Payment_AddressTAG"),WEB_getPropertyValue("Payment_Address"));
    }
    
 
}	