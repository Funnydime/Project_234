import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Scanner;


public class Search extends Menu{
		
	private static Map<Integer, String> SearchResults = new HashMap<Integer, String>();
	private static int Searchindex=1;
	private static Path pathToDatabase= Paths.get("C:\\Users\\Epps\\Desktop\\School\\Fall-2021\\CS _234\\program\\test_database.csv");
	private static String Database = pathToDatabase.toString();
		
	public Search() {
		
		input = "";
		in= new Scanner(System.in);
		
	}
	
	public static void DatabaseCheck() {
		
		try{
			
			System.out.println("Checking for Database.....");
            
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
		
	public static void Title(String Title) {
		
		searchCsvLine(0, Title+".*");
	
	}
		
	public static void Author(String Author) {
		
		searchCsvLine(1, Author+".*");
		
	}
		
	public static void ISBN(String ISBN) {
			
		searchCsvLine(2, ISBN+".*");
		
	}
		
	public static void searchCsvLine(int searchColumnIndex, String searchString){
	
		SearchResults.clear();
		Searchindex=1;
	
		try (BufferedReader br = Files.newBufferedReader(pathToDatabase, StandardCharsets.US_ASCII)) { 
			
			String line = br.readLine();
			while (line != null) {

				String[] attributes = line.split(",");
				String lines = attributes[searchColumnIndex];

					if(lines.matches(searchString)){
						
						String stuff = "Title: "+attributes[0]+", Author: "+attributes[1]+", ISBN: "+attributes[2];
						SearchResults.put(Searchindex, stuff);
						Searchindex++;
					
					}
					
				line = br.readLine(); 
			
			}
				
			BooksFound();
				
		}
			
		catch (Exception e) { 
				
			System.out.println("An error occured, please try again.");
				
		} 
	}
			
	public static void BooksFound() {
			
		if(!SearchResults.isEmpty()) {
				
			while(!input.equals("q")) {
				
				System.out.println("Results found:");
				
				for(int items : SearchResults.keySet()) {
					
					System.out.println("("+items+". "+SearchResults.get(items));
				
				}
				
				System.out.println("Select which to add to cart(e.g. 1  1,2  1,2,3)");
				
				System.out.println("\n(a)dd all\n(s)earch menu\n(m)ain menu\n(c)art menu\n(q)uit");
				
				input = in.nextLine();
				
				try {
				
					if(input.equals("s")) {
						
						Menu.SearchMenu();
					}
					
					else if(input.equals("q")) {
						
						System.exit(0);
					}
					
					else if(input.equals("m")) {
						
						Menu.MainMenu();
					}
					
					else if(input.equals("c")) {
						
						Menu.CartMenu();
					}
					else if(input.equals("a")) {
					
						for(int item : SearchResults.keySet()) {
						
							Cart.AddToCart(SearchResults.get(item));
					
						}
					
					}
					
					else {
							
						String[] selection=input.split(",");
						
						try {
						
							for(String select: selection) {	
								
								String test = SearchResults.get(Integer.valueOf(select));
								
								if(test!=null) {
									
									Cart.AddToCart(SearchResults.get(Integer.valueOf(select)));
									System.out.println("Added "+SearchResults.get(Integer.valueOf(select)));
							
								}
								else{
									
									System.out.println("Invalid input.");
									
								}
							}
						
						}
						catch(Exception e) {
							
							System.out.println("Not a valid input");
							
						}
						
					}
						
				Cart.CartMenu();
				
				}
				
				catch(Exception e){
						
					System.out.println("Not a valid option.");
					
				}
			}
		}
		
		else {
					
			System.out.println("There are no results, please try again.");
		}
	}
}
