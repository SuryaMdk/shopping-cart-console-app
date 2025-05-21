package myPack;

import java.util.regex.Pattern;

public class Categories extends Calculations{
	
	String categoryChoice;
	
	//this method for getting number choice and returns the valid number
	public static String choice() {
		System.out.print("Enter your Option here : ");
		String choice1 = scan.nextLine();
		boolean check = Pattern.matches("\\d{1}",choice1);
		if(check == true) {
			return choice1;
		}else {
			System.out.println("You entered invalid input! Please enter valid number");
			return choice();
		}
	}
	
	
	//this method shows the Home page content of this project
	public String start(){
		System.out.println("\n\t\t\tABC SUPER MARKET\n\t\tWe are pleased to welcome you warmly!!!");
		System.out.println("\n-------- Select your Option ------- \n");
		System.out.println("1. Create User ID\n2. Sign in\n3. Exit\n");
		String startOption;
		boolean b1 = false;
		do {
			startOption = choice();
			if(Integer.parseInt(startOption) > 3) {
				System.out.println("Invalid input. Please enter 1, 2 or 3");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		switch(startOption) {
		case "1":
			welcomeMsg();
			return start();
		case "2":
			return validation();
		case "3":
			System.out.println("\n\n\t\tTHANK YOU!");
		}
		return null;
	}
	
	//this validation method allows to entering the customer to main menu if the customer id is correct
	public String validation() {
		System.out.println("\n\t\tCUSTOMER ID VERIFICATION\n");
		System.out.print("Enter your Customer ID for Sign in : ");
		boolean c1 =false;
		do {
			String customer_Id = scan.nextLine();
			if(customer_Id.equals(customerId)) {
				System.out.println("Customer ID validation Successfully Completed!");
				c1 = true;
			}else {
				System.out.println("\nIncorrect Customer Id!!! Please select your Option(1/2/3)\n1. Re-enter your customer ID\n2. Create a new customer ID\n3. Previous menu \n");
				String startOption;
				boolean b1 = false;
				do {
					startOption = choice();
					if(Integer.parseInt(startOption) > 3) {
						System.out.println("Invalid input. Please enter 1, 2 or 3");
					}
					else {
						b1 = true;
					}
				}while(b1 == false);
				
				
				switch(startOption) {
				case "1":
					return validation();
				case "2":
					welcomeMsg();
					return start();
				case "3":
					return start();				}
			}
		}while(c1 == false);
		
		return ChoiceCategories();
	}
	
	
	//this quantity method used for getting quantity limit from the user and returns the valid number
	int quantity() {
		System.out.print("Enter quantity here : ");
		String quantity = scan.nextLine();
		boolean check = Pattern.matches("\\d{1,2}",quantity);
		if(check == true) {
			return Integer.parseInt(quantity);
		}else {
			System.out.println("You entered invalid input! Please enter valid number");
			return quantity();
		}
	}
	
	
	//choice category method shows Main menu
	public String ChoiceCategories() {
		System.out.println("\n\t\tSELECT YOUR CATEGORY OPTION TO CONTINUE\n\t\t\t\tMAIN MENU");
		System.out.println("1. DISCOUNTED ITEMS\n2. Groceries\n3. Fruits\n4. Vegetables");
		System.out.println("5. Toys\n6. Chocolates\n\n7. I've FINISHED MY PURCHASE\n8. Not Interest to buy\n");
		boolean b1 = false;
		do {
			categoryChoice = choice();
			if(Integer.parseInt(categoryChoice) > 8) {
				System.out.println("Invalid input. Please enter a number between 1 - 8");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		switch(categoryChoice) {
		case "1": 
			return discountedItems();
		case "2":
			return groceries();
		case "3":
			return fruits();
		case "4":
			return vegetables();
		case "5":
			return toys();
		case "6":
			return chocolates();
		case "7":
			return showList();
		case "8":
			return goodByeMsg();
		}
		return null;
	}

	//this shows discounted items page and it returns to main menu page
	public String discountedItems() {
		
		//this prints the list
		System.out.println("\n\t\t\tBIG SUMMER SALE\n");
		System.out.println("1. Maaza 1.2L (Rs.75) * 3 quanity \t- Rs.150/-");
		System.out.println("2. Tata Salt 1kg (Rs.28) \t\t- Rs.25/-");
		System.out.println("3. Good Life Almonds 500g(Rs.550) \t- Rs.365/-");
		System.out.println("4. Sugar 2kg (Rs.50 per kg) \t\t- Rs.82/-");
		System.out.println("5. Amul Butter 100g (Rs.56) \t\t- Rs.50/-");
		System.out.println("\n6. Previous Menu");
		
		//this stores key and values to hash discount object
		hashDiscount.put("Maaza 1.2L (Rs.75) * 3 quanity", 150);
		hashDiscount.put("Tata Salt 1kg (Rs.28)",25);
		hashDiscount.put("Good Life Almonds 500g(Rs.550)",365);
		hashDiscount.put("Sugar 2kg (Rs.50 per kg)",82);
		hashDiscount.put("Amul Butter 100g (Rs.56)",50);

		//this is for getting user choice to pick the item
		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 6) {
				System.out.println("Invalid input. Please enter a number between 1 - 6");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
	
		
		//this switch for storing selected item to list
		int value;
		switch(choiceOption) {
		case "1":
			value = hashDiscount.get("Maaza 1.2L (Rs.75) * 3 quanity");
			hashList.put("Maaza 1.2L (Rs.75) * 3 quanity",value);
			System.out.println("\nYour choice was picked!\n");
			return discountedItems();
		case "2":
			value = hashDiscount.get("Tata Salt 1kg (Rs.28)");
			hashList.put("Tata Salt 1kg (Rs.28)",value);
			System.out.println("\nYour choice was picked!\n");
			return discountedItems();
		case "3":
			value = hashDiscount.get("Good Life Almonds 500g(Rs.550)");
			hashList.put("Good Life Almonds 500g(Rs.550)",value);
			System.out.println("\nYour choice was picked!\n");
			return discountedItems();
		case "4":
			value = hashDiscount.get("Sugar 2kg (Rs.50 per kg)");
			hashList.put("Sugar 2kg (Rs.50 per kg)",value);
			System.out.println("\nYour choice was picked!\n");
			return discountedItems();
		case "5":
			value = hashDiscount.get("Amul Butter 100g (Rs.56)");
			hashList.put("Amul Butter 100g (Rs.56)",value);
			System.out.println("\nYour choice was picked!\n");
			return discountedItems();
		case "6":
			return ChoiceCategories();
		}
		return null;

	}
	
	
	//this method shows groceries page and returns to main menu page
	public String groceries() {
		System.out.println("\n\t\t\tGROCERY ITEMS\n");
		System.out.println("1. Suger 1kg  \t- Rs.50/-");
		System.out.println("2. Rice 1kg  \t- Rs.45/-");
		System.out.println("3. Wheat 1kg  \t- Rs.39/-");
		System.out.println("4. Milk 1L  \t- Rs.40/-");
		System.out.println("5. Egg 1  \t- Rs.5/-");
		System.out.println("6. Butter 100g  - Rs.56/-");
		System.out.println("7. Salt 1kg  \t- Rs.30/-");
		System.out.println("\n8. Previous Menu");
		
		hashGroceries.put("Suger 1kg",50);
		hashGroceries.put("Rice 1kg",45);
		hashGroceries.put("Wheat 1kg",39);
		hashGroceries.put("Milk 1L",40);
		hashGroceries.put("Egg 1",5);
		hashGroceries.put("Butter 100g",56);
		hashGroceries.put("Salt 1kg",30);

		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 8) {
				System.out.println("Invalid input. Please enter a number between 1 - 8");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		
		
		//here quantity also getting from the user
		int value;
		int quantity;
		String itemName;
		switch(choiceOption) {
		case "1":
			itemName = "Suger 1kg";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Suger 1kg" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "2":
			itemName = "Rice 1kg";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Rice 1kg" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "3":
			itemName = "Wheat 1kg";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Wheat 1kg" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "4":
			itemName = "Milk 1L";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Milk 1L" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "5":
			itemName = "Egg 1";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Egg 1" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "6":
			itemName = "Butter 100g";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Butter 100g" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "7":
			itemName = "Salt 1kg";
			value = hashGroceries.get(itemName);
			quantity = quantity();
			itemName = "Salt 1kg" + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYour choice was picked!\n");
			return groceries();
		case "8":
			return ChoiceCategories();
		}
		return null;
	}
	
	
	//this method shows fruits category and it returns to main menu page
	public String fruits() {
		System.out.println("\n\t\tFRUITS\n");
		System.out.println("1. Apple (1kg) \t\t- Rs.350/-");
		System.out.println("2. Orange (1kg) \t- Rs.150/-");
		System.out.println("3. Banana (10 pcs) \t- Rs.100/-");
		System.out.println("4. Mango (1kg) \t\t- Rs.150/-");
		System.out.println("5. Grapes (1kg) \t- Rs.110/-");
		System.out.println("\n6. Previous Menu");
		
		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 6) {
				System.out.println("Invalid input. Please enter a number between 1 - 6");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		
		hashFruits.put("Apple (1kg)",350);
		hashFruits.put("Orange (1kg)",150);
		hashFruits.put("Banana (10 pcs)",100);
		hashFruits.put("Mango (1kg)",150);
		hashFruits.put("Grapes (1kg)",110);

		int value;
		int quantity;
		String itemName;
		switch(choiceOption) {
		case "1":
			itemName = "Apple (1kg)";
			value = hashFruits.get(itemName);
			quantity = quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYout choice was picked!");
			return fruits();
		case "2":
			itemName = "Orange (1kg)";
			value = hashFruits.get(itemName);
			quantity = quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYout choice was picked!");
			return fruits();
		case "3":
			itemName = "Banana (10 pcs)";
			value = hashFruits.get(itemName);
			quantity = quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYout choice was picked!");
			return fruits();
		case "4":
			itemName = "Mango (1kg)";
			value = hashFruits.get(itemName);
			quantity = quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYout choice was picked!");
			return fruits();
		case "5":
			itemName = "Grapes (1kg)";
			value = hashFruits.get(itemName);
			quantity = quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName,value*quantity);
			System.out.println("\nYout choice was picked!");
			return fruits();
		case "6":
			return ChoiceCategories();
		}
		return null;
	}

	//this method for vegetables page
	private String vegetables() {
		System.out.println("\n\t\tVEGETABLES\n");
		System.out.println("1. Onion (1kg) \t\t- Rs.15/-");
		System.out.println("2. Potato (1kg) \t- Rs.22/-");
		System.out.println("3. Tomato (1kg) \t- Rs.25/-");
		System.out.println("4. Coconut (1pc) \t- Rs.25/-");
		System.out.println("5. Drumstick (1pc) \t- Rs.5/-");
		System.out.println("6. Carrot (1kg) \t- Rs.44/-");
		System.out.println("7. Beetroot (1kg) \t- Rs.36/-");
		System.out.println("\n8. Previous Menu");
		
		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 8) {
				System.out.println("Invalid input. Please enter a number between 1 - 8");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		
		hashVegetables.put("Onion (1kg)", 15);
		hashVegetables.put("Potato (1kg)", 22);
		hashVegetables.put("Tomato (1kg)", 25);
		hashVegetables.put("Coconut (1pc)", 25);
		hashVegetables.put("Drumstick (1pc)", 5);
		hashVegetables.put("Carrot (1kg)", 44);
		hashVegetables.put("Beetroot (1kg)", 36);

		int value;
		int quantity;
		String itemName;
		switch(choiceOption) {
		case "1":
			itemName = "Onion (1kg)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "2":
			itemName = "Potato (1kg)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "3":
			itemName = "Tomato (1kg)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "4":
			itemName = "Coconut (1pc)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "5":
			itemName = "Drumstick (1pc)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "6":
			itemName = "Carrot (1kg)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "7":
			itemName = "Beetroot (1kg)";
			value = hashVegetables.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return vegetables();
		case "8":
			return ChoiceCategories();
		}		return null;
	}
	
	
	//this method for toys page
	public String toys() {
		System.out.println("\n\t\tTOYS\n");
		System.out.println("1. Bat \t\t- Rs.500/-");
		System.out.println("2. Ball \t- Rs.50/-");
		System.out.println("3. Car Toy \t- Rs.80/-");
		System.out.println("4. Bike Toy \t- Rs.70/-");
		System.out.println("5. Lion Toy \t- Rs.110/-");
		System.out.println("\n6. Previous Menu");
		
		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 6) {
				System.out.println("Invalid input. Please enter a number between 1 - 6");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		
		hashToys.put("Bat", 500);
		hashToys.put("Ball", 50);
		hashToys.put("Car Toy", 80);
		hashToys.put("Bike Toy", 70);
		hashToys.put("Lion Toy", 110);

		int value;
		int quantity;
		String itemName;
		switch(choiceOption) {
		case "1":
			itemName = "Bat";
			value = hashToys.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYOur Choice was picked!");
			return toys();
		case "2":
			itemName = "Ball";
			value = hashToys.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYOur Choice was picked!");
			return toys();
		case "3":
			itemName = "Car Toy";
			value = hashToys.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYOur Choice was picked!");
			return toys();
		case "4":
			itemName = "Bike Toy";
			value = hashToys.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYOur Choice was picked!");
			return toys();
		case "5":
			itemName = "Lion Toy";
			value = hashToys.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYOur Choice was picked!");
			return toys();
		case "6":
			return ChoiceCategories();
		}
		return null;
	}
	
	
	//this method for chocolates page
	public String chocolates() {
		System.out.println("\n\t\tCHOCOLATES\n");
		System.out.println("1. 5STAR \t\t- Rs.20/-");
		System.out.println("2. Dairy Milk Silk \t- Rs.50/-");
		System.out.println("3. Dairy Milk Bubbly \t- Rs.180/-");
		System.out.println("4. Dark Fantacy \t- Rs.170/-");
		System.out.println("5. Kitkat \t\t- Rs.55/-");
		System.out.println("\n6. Previous Menu");
		
		String choiceOption;
		boolean b1 = false;
		do {
			choiceOption = choice();
			if(Integer.parseInt(choiceOption) > 6) {
				System.out.println("Invalid input. Please enter a number between 1 - 6");
			}
			else {
				b1 = true;
			}
		}while(b1 == false);
		
		hashChocolates.put("5STAR", 20);
		hashChocolates.put("Dairy Milk Silk", 50);
		hashChocolates.put("Dairy Milk Bubbly", 180);
		hashChocolates.put("Dark Fantacy", 170);
		hashChocolates.put("Kitkat", 55);

		int value;
		int quantity;
		String itemName;
		switch(choiceOption) {
		case "1":
			itemName = "5STAR";
			value = hashChocolates.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return chocolates();
		case "2":
			itemName = "Dairy Milk Silk";
			value = hashChocolates.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return chocolates();
		case "3":
			itemName = "Dairy Milk Bubbly";
			value = hashChocolates.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return chocolates();
		case "4":
			itemName = "Dark Fantacy";
			value = hashChocolates.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return chocolates();
		case "5":
			itemName = "Kitkat";
			value = hashChocolates.get(itemName);
			quantity =quantity();
			itemName = itemName + " * " + quantity;
			hashList.put(itemName, value * quantity);
			System.out.println("\nYour choice was picked!\n");
			return chocolates();
		case "6":
			return ChoiceCategories();
		}
		return null;
	}
	
	
	//this method for showing the cart list to the customer and asking to continue your shopping or not
	public String showList() {
		int count = 1;
		int totalAmount = 0;
		System.out.println("\n\t\t\tYOUR CART LIST\n");
		for (String key : hashList.keySet()) {
		      System.out.printf(count++ +" %-33s : %d/-\n" ,key ,hashList.get(key));
		    }
		for (String key : hashList.keySet()) {
			totalAmount += hashList.get(key);
		}
		
		System.out.println("\nTotal Amount is : " + totalAmount + "/-");
		System.out.println("\nDo you want to Continue your Shopping...(Y/N)");
		String choice;
		choice = getChoice();
		if(choice.equalsIgnoreCase("y")) {
			return ChoiceCategories();
		}else {
			return finalBill(totalAmount);
		}
	}
}
