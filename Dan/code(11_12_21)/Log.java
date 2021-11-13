import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Random;

import java.time.LocalDate;

public class Log extends Cart{

    private static String fileName = "./resources/purchaselog.txt";                 //  File name for the Purchase Log

    public static void readLog(){                                                   //  Method for printing the contents of the log    

        System.out.println("\n--------------- PURCHASE LOG ---------------");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while ((line = br.readLine()) != null){                                 //  When the buffered reader reads a line that is not null, it prints it.

                System.out.println(line);

            }

        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");                  //  Catch, primarily for if for some reason the Log file didn't exist yet.

        }

    }

    public static void createFile()                                                         //  Method for creating files
    
    {
    	System.out.println("Checking log file...");

        try{
        	
        	File theLog = new File(fileName);
            if (theLog.createNewFile()){

                System.out.println("Log created: " + theLog.getName() + "\n");              //  Creates new file, unless file already exists.

            }

            else{

                System.out.println("File already exists. \n");

            }
        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");                      //  Catch for any errors
 
        }

    }

    public static void addToLog(String contents)                                            //  Method to add books to the log
    {

        try{
        	
            FileWriter myWriter = new FileWriter(fileName, true);

            LocalDate theDate = LocalDate.now();                                            //  LocalDate library in order to pull today's date
            Random rand = new Random();
            double price = rand.nextInt(100);                                               //  Price is a random double from 0 to 100.

            myWriter.write(theDate + "\t" + contents + "\t" + "   $" +price + "\r");        //  All the user has to enter is the name of the book; or, whatever they want to add.
            myWriter.close();                                                               //  It automatically adds the date to the left of it, and the price to the right.
            System.out.println(contents + " saved to log!");
        }
        catch (Exception e){

            System.out.println("An error occured, please try again.");                      //  Catch for errors

        }

    }

}
