//importing necessary java files
package p_p_3;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 

//Search class extends Menu class
public class Search{
	//Declaring variables needed for the Search class 
	private static HashMap<Integer, String> SearchResults = new HashMap<Integer, String>();
	private static int Searchindex=1;
	private static Path pathToDatabase= Paths.get("..\\book_list.txt");
	private static String Database = pathToDatabase.toString();
        static boolean check;
	//Constructor uses variables from Menu class
	public Search() {
		//Declaring new variable values
                check=false;
	}
	//DatabaseCheck method checks to make sure database exists
	public static boolean DatabaseCheck() {
		//try/catch to error check
		try{
			
			System.out.println("Checking for Database.....");
            	//if the file can be created, the database does not exist, exiting the program
        		File theLog = new File(Database);
        		if (theLog.createNewFile()){

        			check=false;
                
	            }
        		else {
        			
        			check=true;
        		}
		
		}
		catch (Exception e){
			
			System.out.println("An unknown error occured.");
			
		}
                
                return check;
	}
	
        public static HashMap View_All(){
            HashMap <Integer, String>viewall = searchCsvLine(2, "9");
            
            return viewall;
        }
	//searchCSV method searches for the values given by the user, using
	// 0, 1, or 2, depending on if it's the title, author, or ISBN
	public static HashMap searchCsvLine(int searchColumnIndex, String searchString){
		//clearing out the SearchResults Hashmap to get clean results and reseting the index
		searchString = searchString + ".*";
                System.out.println(searchString);
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
						String stuff = attributes[0]+","+attributes[1]+","+attributes[2]+","+attributes[3];
                                               
						SearchResults.put(Searchindex, stuff);
						Searchindex++;
                                                
					}
				//inputing the next line from the Database
				line = br.readLine(); 
			
			}
				
		}
		
		catch (Exception e) { 
			//notifying use of unknown error
			System.out.println("An error occured, please try again.");
				
		} 
                return SearchResults;
	}
	//Booksfound method displays the results of the search	
	
}