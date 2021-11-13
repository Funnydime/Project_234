//Daniel Epps, Dimitri Rodruiguez, Stephen Villanueva
//Novemeber 11, 2021
//CS234
//Project Phase II

//Main Class to execute the program
class Main {

	public static void main(String [] args){
		
		// Checks to make sure ./resources/test_database.csv exists
		Search.DatabaseCheck();
		// Checks to make sure ./resources/purchaselog.txt exists, and if not, creates it
		Log.createFile();
		//calling MainMenu method within the Menu which starts the main program
		Menu.MainMenu();
		
	}
	
}
