import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Log {
    ArrayList<String> logList;
    private int numberofBooks;

    public Log(){
        logList = new ArrayList<String>();
        this.numberofBooks = numberofBooks;
    }

    public void addToData(String logList[]){
        
    }
    public static void main(String[] args) throws IOException {
        //Create the file
        File file = new File("database.txt");
        
        //Create a file writer
        FileWriter fw = new FileWriter(file);

        //Create a print writer
        PrintWriter pw = new PrintWriter(fw);
        pw.write("Map 1");
        pw.write("");
        pw.close();
    }
}
