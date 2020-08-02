package com.testing.utilities;

import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;

public class PalindromeTest {

	private int w;
	private int x;
	private  int y;
	private  int z;

	public Scanner reader = new Scanner(System.in);
	
	public int checkLengthOF(int i) {
		
		 while(i%2==1 && i!=1) {

             System.out.println("Only one odd digit can be allowed to form a palindrome");
			 System.out.println("Please enter the length as 1");
			 i = reader.nextInt();			  
		 }
		 return i;

	}
	public int storeLengthofW() throws Exception{	
		 do {
			 System.out.println("Please enter the length of String from 1 to 20: ");
			 w = reader.nextInt();
			 } while( w>20 || w==0 );
			 System.out.println("Length of W is: " +w);
		return w;	 
	}
	
	
	public int storeLengthofX() throws Exception{		
		 do {
			 System.out.println("Please enter the alphabets of length less than or equal to :" +w);
			 x = reader.nextInt();
		 
			 } while( x>w);
		 
		//  x= checkLengthOF(x);

		 
			 System.out.println("Length of X is: " +x);
			return x;
	}
	
	public int storeLengthofY() throws Exception{	
		 if(!((w-x)==0)){
			 do {
			  System.out.println("Please enter the numbers of length less than or equal to " +(w-x)+":" );
			    y = reader.nextInt();
			 } while(y>(w-x)) ;
			//  y= checkLengthOF(y);

			 System.out.println("Length of Y is: " +y);
			 
		 }  
		 else {
			 System.out.println("Length of Y is equal to Zero");
		 }
		return y;
		
	}
	
	public int storeLengthofZ() throws Exception{	
		 if(!((w-x-y)==0)){
		 do {
			 System.out.println("Please enter the digits of length equal to " +(w-x-y)+":");
			 z = reader.nextInt();
			 } while( z!=(w-x-y));
		 //    z= checkLengthOF(z);

			 System.out.println("Length of Z is: " +z);
		 }
		 else {
			 System.out.println("Length of  Z is equal to Zero");
		 }
		return z;
		 
	}
		
	public void checkPalindrome() throws Exception{	
		
		w= storeLengthofW();
		x= storeLengthofX();
		y= storeLengthofY();
		z= storeLengthofZ();
		 StringBuilder sb = new StringBuilder();
         String randomz= RandomStringUtils.random( z, "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")+sb.toString();
         String randomx=RandomStringUtils.randomAlphabetic(x);
         String randomy= RandomStringUtils.randomNumeric(y).toUpperCase();
		 String inputString= "";
		if((w%2==0&&x==0&&y%2>0&&z%2>0) || (w%2==0&&x%2>0&&y==0&&z%2>0)||(w%2==0&&x%2>0&&y%2>0&&z==0) ||w%2>0&&(x%2>0&&x!=1)&&(y%2>0&&y!=1)&&(z%2>0&&z!=1)) {
			
			
			 System.out.println("Input is not valid to create a Palindrome"); 
		}
		
		else if(w%2==1 && x==1) {
			
			//  x= checkLengthOF(x); 
			 inputString = randomz+randomy;
			 sb = new StringBuilder(inputString).reverse();
			 String finalString = inputString+"A"+sb.toString();
			 checkPalindroe(finalString);
			
		}
		 
		 else if(w%2==1 && y==1) {
			 
			// y= checkLengthOF(y);
			 inputString = randomx+randomz;
			 sb = new StringBuilder(inputString).reverse();
			 String finalString = inputString+"1"+sb.toString();
			 checkPalindroe(finalString);
			
		}
		 
		 else if(w%2==1 && z==1) {
			 
			// z= checkLengthOF(z);
			 inputString = randomx+randomy;
			 sb = new StringBuilder(inputString).reverse();
			 System.out.println("inputString" +inputString);
			 String finalString = inputString+"#"+sb.toString();
			 checkPalindroe(finalString);
			 System.out.println("inputString" +finalString);
			
		}
			
	   else {
		 
		 inputString = RandomStringUtils.randomAlphabetic(x/2).toUpperCase() +RandomStringUtils.randomNumeric(y/2).toUpperCase()+ RandomStringUtils.random( z/2, "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?");
		 sb = new StringBuilder(inputString).reverse();
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

