import java.util.Scanner;

public class Menu {
	
	private static Scanner in= new Scanner(System.in);
	private static String input = "";
	
	public Menu() {
		
	}

	public static void MainMenu(){
	
	
		while(!input.equals("q")) {
		
		
			System.out.println("**********************************************************");
			System.out.println("***************Welcome to the bookstore*******************");
			System.out.println("**********************************************************");
			System.out.println("Please select an option:\n(s)earch menu\n(c)art menu\n(q)uit");
		
			input = in.next();
			
			switch(input.toLowerCase()) {
			
				case "c" : CartMenu();break;
				case "s" : SearchMenu();break;
				case "q" : System.exit(0);
				default : System.out.print("Not a valid option.");break;
			
			}
		}
	}
	
	public static void CartMenu() {
		
		while(!(input.toLowerCase().equals("q"))) {
			
			System.out.println("******************************************");
			System.out.println("***************Cart Menu******************");
			System.out.println("******************************************");
			System.out.println("Please select an option:\n(v)iew cart\n(r)emove item\n(s)earch menu\n(m)ain menu\n(q)uit");
			
			input = in.next();
			
			if(input.equals("v")){
				Cart.ViewCart();
			}
			else if(input.equals("r")) {
				
				Cart.ViewCart();
				System.out.println("\nPlease select a book to remove.\n(a)ll books\n(q)uit");
				input=in.next();
				try{
						
					Cart.RemoveFromCart(input);
					
				}
				catch (Exception e){
						
					System.out.println("Not a valid book.");
				}
					
			}
			else if(input =="c") {
				Menu.CartMenu();
			}
			else if(input.equals("s")) {
				SearchMenu();
			}
			else if(input.equals("m")){
				MainMenu();
			}
			else if(input.equals("q")){
				System.exit(0);
			}
			else { 
				
				System.out.println("Not a valid option.");
			
			}
		}
			
	}
	
	public static void SearchMenu() {
	
	while(!(input.toLowerCase().equals("q"))) {
		
		System.out.println("*******************************************");
		System.out.println("***************Search Menu*****************");
		System.out.println("*******************************************");
		System.out.println("Please select your search method:\n(a)uthor\n(i)sbn\n(t)itle\n(m)ain menu\n(c)art menu\n(q)uit");
		
		input = in.next();
		
		if(input.equals("a")) {
			
			System.out.println("Please input the Author's name:");
			input = in.next();
			Search.Author(input);
		
		}
		
		else if(input.equals("i")) {
			
			System.out.println("Please input the books ISBN:");
			input = in.next();
			Search.Author(input);
		
		}
		
		else if(input.equals("t")) {
			
			System.out.println("Please input the books title:");
			input = in.next();
			Search.Author(input);
		
		}
		
		else if(input.equals("m")) {
			
			MainMenu();
		
		}
		
		else if(input.equals("c")) {
			
			Menu.CartMenu();
		
		}
		
		else if(input.equals("q")) {
			
			System.exit(0);
		
		}
		
		else{
			
			System.out.println("Not a valid option.\n");
			
		}
	
	}
	}
	
}
