import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

import java.time.LocalDate;

public class Log {

    String fileName = "./purchaselog.txt";
    String contents;

    public static void readFile(String fileName)
        throws IOException
    {

        System.out.println("\n--------------- PURCHASE LOG ---------------");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line;

            while ((line = br.readLine()) != null){

                System.out.println(line);

            }

        }catch (IOException e){

            System.out.println("An error occured, please try again.");
            e.printStackTrace();

        }

    }

    public static void createFile()
    {

        System.out.println("\n");

        try{
            File theLog = new File("purchaselog.txt");
            if (theLog.createNewFile()){

                System.out.println("Log created: " + theLog.getName() + "\n");

            }

            else{

                System.out.println("File already exists. \n");

            }
        }
        catch (IOException e){

            System.out.println("An error occured, please try again.");
            e.printStackTrace();

        }


    }

    public static void addToLog(String fileName, String contents)
    {

        try{
            FileWriter myWriter = new FileWriter("purchaselog.txt", true);

            LocalDate theDate = LocalDate.now();
            Random rand = new Random();
            double price = rand.nextInt(100);

            myWriter.write(theDate + "\t" + contents + "\t" + "   $" +price + "\r");
            myWriter.close();
            System.out.println(contents + " saved to log!");
        }
        catch (IOException e){

            System.out.println("An error occured, please try again.");
            e.printStackTrace();

        }

    }
    

}
