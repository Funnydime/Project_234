//importing necessary java packages
import java.util.Scanner;
//Menu class created due to length and amount of menus
public class Menu {
	//delcaring variables for menu
	public static Scanner in= new Scanner(System.in);
	public static String input = "";
	//Main menu method that directs the user to other menus
	public static void MainMenu(){
		//continuing the menu while the user doesn't select "q"
		while(!input.equals("q")) {
			
			System.out.println("**********************************************************");
			System.out.println("***************Welcome to the bookstore*******************");
			System.out.println("**********************************************************");
			System.out.println("Please select an option:\n(s)earch menu\n(c)art menu\n(v)iew log\n(q)uit");
			//prompting user for input
			input = in.nextLine();
			//switch to see what the user chose
			switch(input) {
			
				case "c" : CartMenu();break;
				case "s" : SearchMenu();break;
				case "v" : Log.readLog();break;
				case "q" : System.out.println("Exiting program...");System.exit(0);
				default : System.out.println("Not a valid option.");break;
			
			}
		}
	}
	//Cart menu for specific Cart Options
	public static void CartMenu() {
		//while loop to keep promping user until redirection or quitting the program
		while(!(input.equals("q"))) {
			
			System.out.println("******************************************");
			System.out.println("***************Cart Menu******************");
			System.out.println("******************************************");
			System.out.println("Please select an option:\n(v)iew cart\n(r)emove item\n(s)earch menu\n(m)ain menu\n(c)heckout\n(q)uit");
			//prompting the user for input
			input = in.nextLine();
			//if "v" is selected, prints out the cart for the user
			if(input.equals("v")){
				Cart.ViewCart();
			}
			//if the user selects to remove an item from the cart
			else if(input.equals("r")){
				//as long as the cart is not empty
				if(!Cart.Cartitems.isEmpty()) {
					//prints out cart to show user the options to select from
					Cart.ViewCart();
					System.out.println("If you want more than one book use a \",\" to separate values. Ex. 1,2,4 or 1,4,7");
					System.out.println("\nPlease select a book to remove.\n(a)ll books\n(q)uit");
					//prompting user input
					input=in.nextLine();
					//try/catch for error catching
					try{
						//deletes the entire cart if "a" selected
						if(input.equals("a")) {
							//calling DeleteCart Method in Cart class
							Cart.DeleteCart();
							
						}
						else {
							//calling RemoveFromCart method from Cart Class with input parameters
							Cart.RemoveFromCart(input);
							
						}
					
					}
					//error catching and notifying user
					catch (Exception e){
						
						System.out.println("Not a valid option.");
					}
				}
				//notifying user the cart is empty
				else {
					
					System.out.println("Cart is empty.");
					
				}
					
			}
			//Calling the CheckoutCart method from the Cart Class
			else if(input.equals("c")) {
				//as long as the cart is not empty
				if(!Cart.Cartitems.isEmpty()) {
					Cart.CheckoutCart();
				}
				//notifying user the cart is empty
				else{
					System.out.println("The cart is empty");
				}
			}
			//calling the SearchMenu method within this (Menu) class
			else if(input.equals("s")) {
				SearchMenu();
			}
			//calling the MainMenu method within this (Menu) class
			else if(input.equals("m")){
				MainMenu();
			}
			//quitting the program
			else if(input.equals("q")){
				
				System.out.println("Exting program....");
				System.exit(0);
			
			}
			//notifying the user they input an invalid option
			else { 
				
				System.out.println("Not a valid option.");
			
			}
		}
			
	}
	//searchmenu method that allows the user to search the database csv for availble books
	public static void SearchMenu() {
		//prompts user until the input "q" is selected
		while(!(input.equals("q"))) {
			//printing out menu
			System.out.println("*******************************************");
			System.out.println("***************Search Menu*****************");
			System.out.println("*******************************************");
			System.out.println("Please select your search method:\n(a)uthor\n(i)sbn\n(t)itle\n(m)ain menu\n(c)art menu\n(q)uit");
			//prompting the user for input
			input = in.nextLine();
			//if "a" is selected, it will search by Author Method within the search class with input parameters
			if(input.equals("a")) {
			
				System.out.println("Search supports wildcard. ex. \"A\" returns \"Author1, Author2\", etc...");
				System.out.println("Please input the Author's name:");
				input = in.nextLine();
				//calling Author Method within the search class with input parameter
				Search.Author(input);
		
			}
			//if "i" is selected, it will search by the ISBN Method within the search class with input parameters
			else if(input.equals("i")) {
				
				System.out.println("Search supports wildcard. ex. \"12\" returns \"1234, 1235\", etc...");
				System.out.println("Please input the books ISBN:");
				input = in.nextLine();
				//calling  ISBN Method within the search class with input parameters
				Search.ISBN(input);
		
			}
			//if "t" is selected, it will search by the Title Method within the search class with input parameters
			else if(input.equals("t")) {
				
				System.out.println("Search supports wildcard. ex. \"B\" returns \"Book1, Book2\", etc...");
				System.out.println("Please input the books title:");
				input = in.nextLine();
				//callilng Title Method within the search class with input parameters
				Search.Title(input);
		
			}
			//returns user the the MainMenu method within this class
			else if(input.equals("m")) {
			
				MainMenu();
		
			}
			//returns the user to the CartMenu method within this class
			else if(input.equals("c")) {
			
				CartMenu();
		
			}
			//exits the program
			else if(input.equals("q")) {
			
				System.out.println("Exiting program....");
				System.exit(0);
		
			}
			//notifies the user of invalid inputs
			else{
			
				System.out.println("Not a valid option.\n");
			
			}
		}
	}
}
