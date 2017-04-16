package Assignment2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Libraries {

	public Library[] libraries; // a collection of libraries of type array
	public int numberOfLibraries = 0; // number of libraries in collection
	/**
	 * This constructor calls the searchDirectory(path)
	 * function to scan + build a library from a file
	 * using thebuildLibraryFromFile function.
	 */
	public Libraries() {

		String path = System.getProperty("user.dir") + "/src/Assignment2/test/"; //user directory
		List < List < String >> libraryList = Helper.searchDirectory(path); // searches path for valid files
		numberOfLibraries = libraryList.get(1).size(); //library count
		libraries = new Library[numberOfLibraries];

		for (int i = 0; i < libraries.length; i++) {

			String tempFileName = libraryList.get(1).get(i);
			String libraryName = libraryList.get(0).get(i);

			libraries[i] = (buildLibraryFromFile(tempFileName, libraryName));
		}

		System.out.println("\n----------------------------------------------------------");
		System.out.println("COMPLETE: " + numberOfLibraries + " library files were succesfully loaded");
		System.out.println("----------------------------------------------------------\n");

	}


	// the method takes two String params
	// it reads the file with fileName and creates an object of type Library
	// where the Library has the name defined by the string libraryName
	public Library buildLibraryFromFile(String libraryName, String fileName) {

		Library library = new Library(libraryName);

		String path = System.getProperty("user.dir");
		Book book = null;
		String s;

		try (BufferedReader br = new BufferedReader(new FileReader(path + "/src/Assignment2/test/" + fileName))) {
			// if you run locally on your environment use: new FileReader(path + "/src/" + fileName)
			
			System.out.println("\nLibrary Name: " + libraryName + " Data File: " + fileName);
			System.out.println(" ____________________________________________________________ ");
			System.out.println("|                   Book Title                   | Value Tag |");
			System.out.println("|------------------------------------------------------------|");

			while ((s = br.readLine()) != null) {
				String[] tok = s.split(",");
				String bookName = tok[0];
				int tag = Integer.parseInt(tok[1]);
				book = new Book(bookName, tag);
				library.books.add(book);
				System.out.println(String.format("%-52s %3d %5s", "| " + book.bookName, book.valueTag, " |"));

			}
			System.out.println("|____________________________________________________________|");

		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return library;
	}

	/**
	* Try's to locate the passed in Book
	*@param book object that is searched for in a Library 
	*@return if the book exists the Library it was found in is returned else null
	*/
	public Library isThereBookInLibraries(Book book) {

		for (Library lib: libraries) {

			for (Book b: lib.books) {
				if (b.equals(book)) {
					return lib;
				}
			}
		}
		return null;
	}

	public Vector < Library > findBookInAllLibraries(Book b) {

		Vector < Library > libs = new Vector < Library > ();

		for (Library l: this.libraries) {
			for (Book bk: l.getBooks()) {
				if (bk.getBookName().equals(b.getBookName())) {
					libs.add(l);
				}
			}
		}
		return libs;
	}

	/** the method takes three params: a book and two dates that defines the
	*desire rented period. The method returns the first library where the book
	*is available and can be rented*/
	public Library rentBookAvailable(Book book, String requestDate, String dueDate) {

		Library foundLibrary = null;
		return foundLibrary;
	}
	
	@Override
	public String toString() {
		return "Libraries [libraries=" + Arrays.toString(libraries) + ", numberOfLibraries=" + numberOfLibraries + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(libraries);
		result = prime * result + numberOfLibraries;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Libraries))
			return false;
		Libraries other = (Libraries) obj;
		if (!Arrays.equals(libraries, other.libraries))
			return false;
		if (numberOfLibraries != other.numberOfLibraries)
			return false;
		return true;
	}
}