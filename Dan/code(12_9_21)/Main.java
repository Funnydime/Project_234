package p_p_3;

//Daniel Epps, Dimitri Rodruiguez, Stephen Villanueva
//Novemeber 11, 2021
//CS234
//Project Phase II

//Main Class to execute the program
class Main {

	public static void main(String [] args){
		
		// Checks to make sure ./resources/test_database.csv exists
		
		// Checks to make sure ./resources/purchaselog.txt exists, and if not, creates it
		
		//creating new GUI object method within the Menu which starts the main program
                //new loading_screen().setVisible(true);
                    //Log.createFile();
                    //Search.DatabaseCheck();
                
		new Bookstore_GUI().setVisible(true);
		
	}
	
}
