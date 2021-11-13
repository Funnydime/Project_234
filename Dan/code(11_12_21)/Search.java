//importing necessary java files
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Scanner;

//Search class extends Menu class
public class Search extends Menu{
	//Declaring variables needed for the Search class 
	private static Map<Integer, String> SearchResults = new HashMap<Integer, String>();
	private static int Searchindex=1;
	private static Path pathToDatabase= Paths.get("./resources/test_database.csv");
	private static String Database = pathToDatabase.toString();
	//Constructor uses variables from Menu class
	public Search() {
		//Declaring new variable values
		input = "";
		in= new Scanner(System.in);
		
	}
	//DatabaseCheck method checks to make sure database exists
	public static void DatabaseCheck() {
		//try/catch to error check
		try{
			
			System.out.println("Checking for Database.....");
            	//if the file can be created, the datbase does not exist, exiting the program
        		File theLog = new File(Database);
        		if (theLog.createNewFile()){

        			System.out.println("***************!!!!Database not found!!!!*****************");
        			System.out.println("Exiting program...");
        			System.exit(0);
                
	            }
        		else {
        			
        			System.out.println("Database found!");
        		}
		
		}
		catch (Exception e){
			
			System.out.println("An unknown error occured.");
			
		}
	}
	//title method, to search by title, receives the Title value
	public static void Title(String Title) {
		//calling the searchCSVLine method with Title parameters
		searchCsvLine(0, Title+".*");
	
	}
	//title method, to search by title, receives the Author value
	public static void Author(String Author) {
		//calling the searchCSVLine method with Author parameters
		searchCsvLine(1, Author+".*");
		
	}
	//title method, to search by title, receives the ISBN value
	public static void ISBN(String ISBN) {
		//calling the searchCSVLine method with ISBN parameters
		searchCsvLine(2, ISBN+".*");
		
	}
	//searchCSV method searches for the values given by the user, using
	// 0, 1, or 2, depending on if it's the title, author, or ISBN
	public static void searchCsvLine(int searchColumnIndex, String searchString){
		//clearing out the SearchResults Hashmap to get clean results and reseting the index
		SearchResults.clear();
		Searchindex=1;
		//implementing try/catch for error catching
		try (BufferedReader br = Files.newBufferedReader(pathToDatabase, StandardCharsets.US_ASCII)) { 
			//reading the initial line of the file to get a value
			String line = br.readLine();
			while (line != null) {
				//creating an array to be able to index the value, 0:Title, 1:Author, 2:ISBN
				String[] attributes = line.split(",");
				String lines = attributes[searchColumnIndex];
					//if to see if the value matches the search request
					if(lines.matches(searchString)){
						//creating a string and adding it to the SearchResults Hashmap and increasing index
						String stuff = "Title: "+attributes[0]+", Author: "+attributes[1]+", ISBN: "+attributes[2];
						SearchResults.put(Searchindex, stuff);
						Searchindex++;
					
					}
				//inputing the next line from the Database
				line = br.readLine(); 
			
			}
			//calling the Booksfound method to display the results
			BooksFound();
				
		}
		
		catch (Exception e) { 
			//notifying use of unknown error
			System.out.println("An error occured, please try again.");
				
		} 
	}
	//Booksfound method displays the results of the search	
	public static void BooksFound() {
		//if there are results, do the following
		if(!SearchResults.isEmpty()) {
			//inner menu loop that will continue until the input is "q"
			while(!input.equals("q")) {
				//Printing out results
				System.out.println("Results found:");
				
				for(int items : SearchResults.keySet()) {
					
					System.out.println("("+items+". "+SearchResults.get(items));
				
				}
				//inner menu to prompt the user for their selection
				System.out.println("Select which to add to cart(e.g. 1  1,2  1,2,3)");
				
				System.out.println("\n(a)dd all\n(s)earch menu\n(m)ain menu\n(c)art menu\n(q)uit");
				
				input = in.nextLine();
				//checking the user input to see what the user selected
				try {
					//if that sends the user back to the SearchMenu Method in the Menu class
					if(input.equals("s")) {
						
						Menu.SearchMenu();
					}
					//if that quits the program
					else if(input.equals("q")) {
						
						System.exit(0);
					}
					//if that sends the user to the MainMenu Method in the Menu class
					else if(input.equals("m")) {
						
						Menu.MainMenu();
					}
					//if that sends the user to the CartMenu Method in the Menu class
					else if(input.equals("c")) {
						
						Menu.CartMenu();
					}
					//if that adds ALL books from the results to the cart
					else if(input.equals("a")) {
						//forloop for adding all the items from the search results
						for(int item : SearchResults.keySet()) {
							//calling the AddToCart method in the Cart class to add the items from the Search Results HashMap
							Cart.AddToCart(SearchResults.get(item));
					
						}
					
					}
					//if the user inputs multiple items separated by a comma, the program will try this
					else {
						//creating an array by using a commma as a deliminator
						String[] selection=input.split(",");
						//try/catch for error processing
						try {
							//forloop for processsing each value in the "selection" array
							for(String select: selection) {	
								//test String checks whether or not the value exists in the HashMap
								String test = SearchResults.get(Integer.valueOf(select));
								//if it returns a value, it adds the value to the cart
								if(test!=null) {
									//adding the search results selection to the cart and notifying user of success
									Cart.AddToCart(SearchResults.get(Integer.valueOf(select)));
									System.out.println("Added "+SearchResults.get(Integer.valueOf(select)));
							
								}
								else{
									//if the user inputs an invalid option, they will be notified
									System.out.println("Invalid input.");
									
								}
							}
						
						}
						//error catching and notifying the user
						catch(Exception e) {
							
							System.out.println("Not a valid input");
							
						}
						
					}
				//Returning the user to the Cart menu whether it was successful or not
				Cart.CartMenu();
				
				}
				//general error catching
				catch(Exception e){
						
					System.out.println("Not a valid option.");
					
				}
			}
		}
		//notifying the user there are no results from the selected search
		else {
					
			System.out.println("There are no results, please try again.");
		}
	}
}
