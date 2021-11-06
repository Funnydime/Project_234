import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader; 
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.Scanner;


public class Search {
		
	private static Scanner in= new Scanner(System.in);
	private static String input="";
	private static Map<Integer, String> SearchResults = new HashMap<Integer, String>();
	private static int index=1;
	private static Path pathToFile= Paths.get("C:\\Users\\Epps\\Desktop\\School\\Fall-2021\\CS _234\\program\\test_database.csv");
		
	public Search() {

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
		index=1;
	
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			
			String line = br.readLine();
			while (line != null) {

				String[] attributes = line.split(",");
				String lines = attributes[searchColumnIndex];

					if(lines.matches(searchString)){
						
						String stuff = "Title: "+attributes[0]+", Author: "+attributes[1]+", ISBN: "+attributes[2];
						SearchResults.put(index, stuff);
						index++;
					
					}
					
				line = br.readLine(); 
			
			}
				
			BooksFound();
				
		}
			
		catch (IOException ioe) { 
				
			ioe.printStackTrace(); 
				
		} 
	}
			
	public static void BooksFound() {
			
		if(!SearchResults.isEmpty()) {
				
			while(!input.equals("q")) {
				
				System.out.println("Results found, select which to add to cart(e.g. 1  1,2  1,2,3)");
				
				for(int items : SearchResults.keySet()) {
					
					System.out.println("("+items+". "+SearchResults.get(items));
				
				}
				
				System.out.println("\n(a)dd all\n(s)earch menu\n(m)ain menu\n(c)art menu\n(q)uit");
				
				input = in.next();
				
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
								
								Cart.AddToCart(SearchResults.get(Integer.valueOf(select)));
							
							}
						}
						catch(Exception e) {
							
							System.out.println("Not a valid input");
							
						}
						
					}
						
						Menu.SearchMenu();
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
