package myPack;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;

public class SuperClass {
	
	//instance object creation for scanner and random class
	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();

	//instance variables creation for all sub classes
	static String firstName, lastName, name, mobileNo, permanentAddress, deliveryAddress,customerId;
	static int deliveryCharge;
	
	//welcome message method for starting an id creation
	String welcomeMsg() {
		System.out.println("\n\t\t\tCUSTOMER ID CREATION");
		System.out.println("\t\tPlease Fill Your Details Correctly...\n");
		return getFirstName();
	}
	
	//get first name method and it returns to get last name method
	static String getFirstName() {
		System.out.print("Enter your First Name : ");
		firstName = scan.nextLine();
		
		boolean check = Pattern.matches("^[A-Za-z]+$",firstName);
		if(check == true) {
			return getLastName();
		}else {
			System.out.println("You entered invalid input! Please enter valid name");
			return getFirstName();
		}
	}
	
	//get last name method for getting last name of user and it returns to full name method
	static String getLastName() {
		System.out.print("Enter your Last Name : ");
		lastName = scan.nextLine();
		boolean check = Pattern.matches("^[A-Za-z]+$",lastName);
		if(check == true) {
			return getName();
		}else {
			System.out.println("You entered invalid input! Please enter valid name");
			return getLastName();
		}
	}
	
	//this method for merging first name and last name and returns to get mobile no method
	static String getName() {
		name = firstName + " " + lastName;
		return getMobileNo();
	}
	
	//this method gets valid mobile number and returns to get address method
	static String getMobileNo() {
		System.out.print("Enter your Moblie number : ");
		mobileNo = scan.nextLine();
		boolean check = Pattern.matches("[6789]{1}\\d{9}",mobileNo);
		if(check == true) {
			return getAddress();
		}else {
			System.out.println("You entered invalid input! Please re enter valid 10 digit mobile number");
			return getMobileNo();
		}
	}
	
	//this method for getting address and it returns to get delivery address method
	static String getAddress() {
		System.out.print("Enter your Permanent Address : ");
		permanentAddress = scan.nextLine();
		boolean check = Pattern.matches("^[\\sa-zA-z0-9\\W]+$",permanentAddress);
		if(check == true) {
			return getDeliveryAddress();
		}else {
			System.out.println("You entered invalid input! Please re enter valid Address! ");
			return getAddress();
		}
	}
	
	//this method gets valid delivery area and it returns first 2 digit of the delivery area name to customer id creation method
	static String getDeliveryAddress() {
		System.out.println("Select your Delivery Area \n1. Palanganatham\n2. Jaihindpuram\n3. Thirupangundram\n4. Kalavasal\n5. Other");
		boolean c1 = false;
		String selectOption;
		do {
			System.out.print("Select your option : ");
			selectOption = scan.nextLine();
			
			boolean check = Pattern.matches("[12345]{1}",selectOption);
			if(check == true) {
				c1 =true;
			}else {
				System.out.println("You entered invalid input! Please select valid number");
			}
		}while(c1==false);
		
		switch(selectOption) {
		case "1":
			deliveryAddress = "Palanganatham";
			deliveryCharge = 20;
			break;
		case "2":
			deliveryAddress = "Jaihindpuram";
			deliveryCharge = 30;
			break;
		case "3":
			deliveryAddress = "Thiruparangundram";
			deliveryCharge = 40;
			break;
		case "4":
			deliveryAddress = "Kalavasal";
			deliveryCharge = 35;
			break;
		case "5":
			System.out.print("Enter your delivery Area : ");
			deliveryAddress = scan.nextLine();
			deliveryCharge = 40;
			break;
		}
		
		boolean check1 = Pattern.matches("^[A-Za-z]{2}[a-zA-z0-9,.\\s]+$",deliveryAddress);
		if(check1 == true) {
			return customerId(deliveryAddress.substring(0,2).toUpperCase());
		}else {
			System.out.println("You entered invalid input! Please re enter correct value");
			return getDeliveryAddress();
		}
	
		
	}

	//this method creates a customer id and it stores the value in customer id variable and it dosn't return any method
	 static String customerId(String area) {
			String shopName = "ABC";
			int randomNumber = random.nextInt(8999) + 1000;
			customerId = shopName + randomNumber + area;
			
			System.out.println("\n\nCongrats... You've created your ID Successfully!\n");
			System.out.println("Your customer ID is : " + customerId);
			//System.out.println("Your delivery  Area is : " + deliveryAddress);

			return null;
		}
	 
	 //this method for yes or no choice getting  method and it returns the choice
	static String getChoice() {
		String choice;
		System.out.print("Enter your Choice : ");
		choice = scan.nextLine();
		
		boolean check = Pattern.matches("[YyNn]{1}",choice);
		if(check == true) {
			return choice;
		}else {
			System.out.println("You entered invalid input! Please enter valid input (Y/N)");
			return getChoice();
		}
	}
	
	
	

}
