package myPack;

import java.util.Hashtable;

public class Calculations extends SuperClass{
	
	//object creation for HashTable class (Storing all data)
	Hashtable<String, Integer> hashDiscount = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashGroceries = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashFruits = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashVegetables = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashToys = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashChocolates = new Hashtable<String, Integer>(10);
	Hashtable<String, Integer> hashList = new Hashtable<String, Integer>(30);


	//this method using for final bill printing...
	String finalBill(int totalAmount) {
		System.out.println("\nDo you pick up your items yourself\nor do you want us to ship them home?");
		System.out.println("\nIf yes press Y or press N");
		String deliveryChoice = getChoice();
		
		System.out.println("\n\t\t\tYOUR BILL\n");
		System.out.println("Customer Name : " + name.toUpperCase());
		System.out.println("Customer ID : " + customerId);
		System.out.println("Purchased Bill Amount : " + totalAmount + "/-");
		if(deliveryChoice.equalsIgnoreCase("y")) {
			System.out.println("Delivery Charge is : " + deliveryCharge + "/-");
			System.out.println("Your Final bill Amount is : " + (totalAmount+deliveryCharge) + "/-");	
		}
		System.out.println("\nDo you want to join Lucky Draw (Y/N)");
		String choice = getChoice();
		if(choice.equalsIgnoreCase("y")) {
			return luckyDraw();
		}else {
			return goodByeMsg();
		}
	}
	
	//This method for saying good bye to the customer and it is end of this project
	String goodByeMsg() {
		System.out.println("\n\n\t\tTHANK YOU " + firstName.toUpperCase() + " FOR VISITING HERE...");
		return null;
	}
	
	//lucky draw method for performs the game with random number
	String luckyDraw() {
		System.out.print("Enter your Customer ID for Joining Lucky Draw ");
		boolean c1 =false;
		do {
			String customer_Id = scan.nextLine();
			if(customer_Id.equals(customerId)) {
				System.out.println("You're Successfully joined Lucky draw!");
				c1 = true;
			}else {
				System.out.print("Please Enter correct Customer Id : ");
			}
		}while(c1 == false);
		
		int luckyNumber;
		System.out.println("\n\t\t Prizes\n1. Iphone 14 pro\n2. Ipl finals 5 tickets\n3. Better Luck next time\n4. Madurai to Delhi 2 Flight Tickets\n5. Better luck next time");
		System.out.println("\nStart your spin by entering Y(or press N) ");
		String spin = getChoice();
		if(spin.equalsIgnoreCase("y")) {
			luckyNumber=random.nextInt(5);
			
			System.out.println("\n\nYour Lucky number is " + luckyNumber);
			switch(luckyNumber) {
			case 1: 
				System.out.println("Congrats... You got an iphone 14 pro");
				break;
			case 2: 
				System.out.println("Congrats... You got an IPL finals 5 tickets");
				break;
			case 3: 
				System.out.println("Better Luck next time");
				break;
			case 4: 
				System.out.println("Congrats... You got a Madurai to Delhi 2 Flight Tickets");
				break;
			case 5: 
				System.out.println("Better Luck next time");
				break;
			}
		}
		
		return goodByeMsg();
	}
	
}
