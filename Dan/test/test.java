import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class test{
	
		public static void main(String[] args) {
		
		int x=3;
		String ainput;
		String bookinfo;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter:\n(a)uthor\n(i)sbn\n(n)ame\n(q)uit");
			ainput=input.next();
			if(ainput.equals("a")||ainput.equals("i")||ainput.equals("n")) {
				
				switch(ainput) {
				case "n": x=0 ;break;
				case "i": x=1 ;break;
				case "a": x=2 ;break;
				}
				
				System.out.print("Please input the book information: ");
				bookinfo=input.next();
				bookinfo="(.*)"+bookinfo+"(.*)";
				ArrayList<Books> listofbooks= readBooksFromCSV("C:\\Users\\Epps\\Desktop\\School\\Fall-2021\\CS _234\\program\\book_list.csv", x, bookinfo);
			
				int size = listofbooks.size();
				if(size!=0) {
				
					for (Books b : listofbooks) { 
						System.out.println(b); 
					}
				}
				else {
					System.out.println("No books found");
				}
			
			}
			else {
			
				System.out.println("Please choose a valid option:\n(a)uthor\n(i)sbn\n(n)ame\n(q)uit");
			
			}
		}while(!(ainput.equals("q")));
}
	
	public static ArrayList<Books> readBooksFromCSV(String book_list, int x, String bookinfo){
		ArrayList<Books> books = new ArrayList<>(); 
		Path pathToFile = Paths.get("C:\\Users\\Epps\\Desktop\\School\\Fall-2021\\CS _234\\program\\book_list.csv"); 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
			String line = br.readLine();
			while (line != null) {
					String[] attributes = line.split(",");
					if(attributes[x].matches(bookinfo)){
						Books book = createBook(attributes);
						books.add(book);
					}
				line = br.readLine(); 
			}
		}
		
		catch (IOException ioe) { 
			
			ioe.printStackTrace(); 
			
		} 
		return books;
	}
	
	public static Books createBook(String[] metadata) {
		String name = metadata[0];
		String isbn = metadata[1];
		String author=metadata[2];
		
		return new Books(name, isbn, author);
	}
}