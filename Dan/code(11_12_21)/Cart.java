import java.util.Map;
import java.util.HashMap;

public class Cart extends Search{
	//declaring variables needed for the cart class
	private static int Cartindex = 1;
	//Creating Hashmaps to manage the cart items
	protected static Map<Integer, String> Cartitems = new HashMap<Integer, String>();
	private static Map<Integer, String> Itemplaceholder = new HashMap<Integer, String>();
	//ViewCart Method that prints out the cart
	public static void ViewCart() {
		//If the cart isn't empty, it prints each item from the HashMap
		if (!(Cartitems.isEmpty())) {

			for (int item : Cartitems.keySet()) {
				//Printing individual items from for loop
				System.out.println(item + ".) " + Cartitems.get(item));

			}
			
		} 
		//if the cart is empty, notifying the user
		else {

			System.out.println("The cart is empty.");

		}
	}
	//AddToCart method needs the selected books parameter(recieved from Search.BooksFound())
	public static void AddToCart(String selectedbook) {
		//try/catch for error catching
		try {
			//adding the selected bool to the Cartitems HashMap
			Cartitems.put(Cartindex, selectedbook);
			//increasing index to keep a unique key
			Cartindex++;

		}
		//catching errors
		catch (Exception e) {
			//notifying user no books were found
			System.out.println("Books not found.");

		}
		//re-ording the cart due to item changes
		reorderCart();
	}
	//RemoveFromCart method receives a String parameter to see what the user selected to remove
	public static void RemoveFromCart(String x) {
		//shows that it is attempting to remove an item
		System.out.println("Removing item: " + x);
		//if the cart is not empty
		if (!Cartitems.isEmpty()) {
			//try/catch for error catching
			try {
				//if the String doesn't contain a comma, it at 
				if (!(x.contains(","))) {
					//testing to see if the value exists
					String test=Cartitems.get(Integer.valueOf(x));
					//if it does, it attempts to remove it
					if(test!=null) {
						
						Cartitems.remove(Integer.valueOf(x));
						System.out.println("Book " + x + " successfully removed.");
						Cartindex--;
					
					}
					//notifying the user of invalid input
					else {
						
						System.out.println("Invalid input.");
						
					}

				}
				//if the input contains a comma, it indicates multiple values to be removed
				else {
					//creating an array with a comma as the deliminator
					String[] stuff = x.split(",");
					//forloop for removing each item
					for (String a : stuff) {
						//checking to see if the value exists
						String test=Cartitems.get(Integer.valueOf(a));
						//if it does exist, it attempts to remove it
						if(test!=null) {
							
							Cartitems.remove(Integer.valueOf(a));
							Cartindex--;
							System.out.println("Book " + a + " successfully removed.");
							
						}
						//if it doesn't it notifies user of the invalid input
						else {
							System.out.println("Invalid input.");
						}

					}

				}

			}
			//catching the error, and notifying the book selected could not be found
			catch (Exception e) {

				System.out.println("Book not found.");

			}
			//reording the cart with reorderCart Method after removal of items. 
			//Ex. If item 2 removed from list 1,2,3, numbering would be 1,3 unless corrected
			
			reorderCart();
			
		}
		//notifying the user the cart is empty
		else {

			System.out.println("The cart is empty.");

		}

	}
	//method DeleteCart removes all all items from all carts and resets the index used to number the HashMaps
	public static void DeleteCart() {

		Cartitems.clear();
		Itemplaceholder.clear();
		Cartindex = 1;
		System.out.println("All items removed.");

	}
	//reorderCart() method reorders cart.
	//Ex. If item 2 removed from list 1,2,3, numbering would be 1,3 unless corrected
	public static void reorderCart() {
		//checking to make sure Cartiems is not empty
		if(!Cartitems.isEmpty()) {
		//setting values and variables to ensure proper indexing
		int x=1;
		Itemplaceholder.clear();
			  //moving the items from cartitems to the placeholder hashmap with proper indexing
			  for(int item : Cartitems.keySet()) {
				  
				  Itemplaceholder.put(x, Cartitems.get(item));
				  x++;
			  }
			  //clearing out the Cartitems HashMap
			  Cartitems.clear();
			  //adding the items back to the Cartitems Hashmap(the one that is printed out)
			  for(int item : Itemplaceholder.keySet()) {
				  	
				  Cartitems.put(item, Itemplaceholder.get(item));
	  
			  }
		}
	}
	//CheckoutCard Method adds the cart items to the ./resources/purchaselog.txt file
	public static void CheckoutCart() {
		//forloop to add the items
		for(int item : Cartitems.keySet()) {
			//calling the addToLog method in the Log class
			//the parameter is ugly, but it's a decomposed Hashmap that is turned into an array
			//the title from the array is selected(index 0), converted to string, and has selected text removed
			//then the item is added
			Log.addToLog(Cartitems.get(item).split(",")[0].toString().replace("Title: ", ""));
		
		}
		//clearing out the cart after the user checks out
		Cartitems.clear();
	}
}
