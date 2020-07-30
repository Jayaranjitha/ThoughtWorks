package com.testing.utilities;

import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

public class PalindromeTest {

	private int w;
	private int x;
	private  int y;
	private  int z;

	public Scanner reader = new Scanner(System.in);
	
	public void storeLengthofW() throws Exception{	
		 do {
			 System.out.println("Please enter the length of String from 1 to 20: ");
			 w = reader.nextInt();
			 } while( w>20 || w==0);
			 System.out.println("Length of W is: " +w);
			 
	}
	
	public void storeLengthofX() throws Exception{		
		 do {
			 System.out.println("Please enter the alphabets of length less than or equal to :" +w+":");
			 x = reader.nextInt();
			 } while( x>w);
			 System.out.println("Length of X is: " +x);
	}
	
	public void storeLengthofY() throws Exception{	
		 if(!((w-x)==0)){
			 do {
			  System.out.println("Please enter the numbers of length less than or equal to " +(w-x)+":");
			    y = reader.nextInt();
			 } while(y>(w-x)) ;
			 System.out.println("Length of Y is: " +y);
		 }  
		 else {
			 System.out.println("Length of Y is equal to Zero");
		 }
		
	}
	
	public void storeLengthofZ() throws Exception{	
		 if(!((w-x-y)==0)){
		 do {
			 System.out.println("Please enter the digits of length equal to " +(w-x-y)+":");
			 z = reader.nextInt();
			 } while( z!=(w-x-y));
			 System.out.println("Length of Z is: " +z);
		 }
		 else {
			 System.out.println("Length of  Z is equal to Zero");
		 }
	}
		
	public void checkPalindrome() throws Exception{	
		
		 storeLengthofW();
		 storeLengthofX();
		 storeLengthofY();
		 storeLengthofZ();
  
		if(w%2>0||x%2>0||y%2>0||z%2>0) {
			
			 System.out.println("Input is not valid to create a Palindrome"); 
		}
		else {
		 
		 String inputString = RandomStringUtils.randomAlphabetic(x/2).toUpperCase() +RandomStringUtils.randomNumeric(y/2).toUpperCase()+ RandomStringUtils.random( z/2, "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?");
		 StringBuilder sb = new StringBuilder(inputString).reverse();
		 String finalString = inputString+sb.toString();
		 checkPalindroe(finalString);
		}
	
	}
	
	public void checkPalindroe(String inputString) throws Exception {
		  
		 int length = inputString.length();
		 String reverseString ="";
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	         reverseString = reverseString + inputString.charAt(i);
	      if (inputString.equalsIgnoreCase(reverseString) && !(inputString.equalsIgnoreCase(""))) {
	         System.out.println("Valid Palindrome" +inputString);
	         }
	   }

	
	 public static void main(String args[]) throws Exception
	   {  
		 PalindromeTest palindrome = new PalindromeTest();
		
		 palindrome.checkPalindrome();
		 
	   }
}

