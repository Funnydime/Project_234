public class Books {

		private String name;
		private String isbn;
		private String author;
		
		public Books(String name, String isbn, String author) {
			this.name = name;
			this.isbn = isbn;
			this.author = author;
			
		} 
		@Override public String toString() { 
			return "Book [name=" + name + ", ISBN=" + isbn+ ", author=" + author + "]"; 
		}
}
