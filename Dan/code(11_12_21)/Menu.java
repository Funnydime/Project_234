import java.util.Scanner;

public class Menu {
	
	public static Scanner in= new Scanner(System.in);
	public static String input = "";

	public static void MainMenu(){
	
		while(!input.equals("q")) {
			
			System.out.println("**********************************************************");
			System.out.println("***************Welcome to the bookstore*******************");
			System.out.println("**********************************************************");
			System.out.println("Please select an option:\n(s)earch menu\n(c)art menu\n(v)iew log\n(q)uit");
		
			input = in.nextLine();
			
			switch(input) {
			
				case "c" : CartMenu();break;
				case "s" : SearchMenu();break;
				case "v" : Log.readLog();break;
				case "q" : System.out.println("Exiting program...");System.exit(0);
				default : System.out.println("Not a valid option.");break;
			
			}
		}
	}
	
	public static void CartMenu() {
		
		while(!(input.equals("q"))) {
			
			System.out.println("******************************************");
			System.out.println("***************Cart Menu******************");
			System.out.println("******************************************");
			System.out.println("Please select an option:\n(v)iew cart\n(r)emove item\n(s)earch menu\n(m)ain menu\n(c)heckout\n(q)uit");
			
			input = in.nextLine();
			
			if(input.equals("v")){
				Cart.ViewCart();
			}
			else if(input.equals("r")){
				
				if(!Cart.Cartitems.isEmpty()) {
				
					Cart.ViewCart();
					System.out.println("\nPlease select a book to remove.\n(a)ll books\n(q)uit");
					input=in.nextLine();
					try{
						
						if(input.equals("a")) {
							
							Cart.DeleteCart();
							
						}
						else {
							
							Cart.RemoveFromCart(input);
							
						}
					
					}
					catch (Exception e){
						
						System.out.println("Not a valid option.");
					}
				}
				else {
					
					System.out.println("Cart is empty.");
					
				}
					
			}
			else if(input.equals("c")) {
				Cart.CheckoutCart();
			}
			else if(input.equals("s")) {
				SearchMenu();
			}
			else if(input.equals("m")){
				MainMenu();
			}
			else if(input.equals("q")){
				
				System.out.println("Exting program....");
				System.exit(0);
			
			}
			else { 
				
				System.out.println("Not a valid option.");
			
			}
		}
			
	}
	
	public static void SearchMenu() {
	
		while(!(input.equals("q"))) {
		
			System.out.println("*******************************************");
			System.out.println("***************Search Menu*****************");
			System.out.println("*******************************************");
			System.out.println("Please select your search method:\n(a)uthor\n(i)sbn\n(t)itle\n(m)ain menu\n(c)art menu\n(q)uit");
		
			input = in.nextLine();
		
			if(input.equals("a")) {
			
				System.out.println("Search supports wildcard. ex. \"A\" returns \"Author1, Author2\", etc...");
				System.out.println("Please input the Author's name:");
				input = in.nextLine();
				Search.Author(input);
		
			}
		
			else if(input.equals("i")) {
				
				System.out.println("Search supports wildcard. ex. \"12\" returns \"1234, 1235\", etc...");
				System.out.println("Please input the books ISBN:");
				input = in.nextLine();
				Search.ISBN(input);
		
			}
		
			else if(input.equals("t")) {
				
				System.out.println("Search supports wildcard. ex. \"B\" returns \"Book1, Book2\", etc...");
				System.out.println("Please input the books title:");
				input = in.nextLine();
				Search.Title(input);
		
			}
		
			else if(input.equals("m")) {
			
				MainMenu();
		
			}
		
			else if(input.equals("c")) {
			
				Menu.CartMenu();
		
			}
		
			else if(input.equals("q")) {
			
				System.out.println("Exiting program....");
				System.exit(0);
		
			}
		
			else{
			
				System.out.println("Not a valid option.\n");
			
			}
		}
	}
}
