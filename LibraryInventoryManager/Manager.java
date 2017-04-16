package Assignment2;

import java.util.Vector;

public class Manager {

	private Libraries ls;
	private Library library;
	public Manager() {

}

	public void setLs(Libraries ls) {
		this.ls = ls;
	}

	public Libraries getLs() {
		return ls;
	}

	public void TaskTwo(Book book) {
		Library library = this.ls.isThereBookInLibraries(book);
		if (library == null) {
			System.out.println(Helper.printNonexistent(book));
		}
	}

	public void TaskThree(Book book2) {

		library = this.ls.isThereBookInLibraries(book2);

		if (library != null) {
			System.out.println("\n" + Helper.printAvailable(book2, Helper.getCurrentDate(), library));
			book2.rentBook(Helper.getCurrentDate(), "05/13/2017", library);
		}
		else {
			System.out.println("\n" + Helper.printUnavailable(book2, Helper.getCurrentDate()));
		}
		Library library2 = this.ls.isThereBookInLibraries(book2);

		if (library2 != null) {
			System.out.println("\n" + Helper.printAvailable(book2, Helper.getCurrentDate(), library2));
			book2.rentBook(Helper.getCurrentDate(), "05/13/2017", library2);
		}
		else {
			System.out.println("\n" + Helper.printUnavailable(book2, Helper.getCurrentDate()));
		}

		book2.returnBook(library);
		library = this.ls.isThereBookInLibraries(book2);

		String rentDate = "07/10/2017";
		if (library != null) {
			System.out.println("\n" + Helper.printAvailable(book2, rentDate, library));
			book2.rentBook(rentDate, "08/19/2017", library);
		}
		else {
			System.out.println("\n" + Helper.printUnavailable(book2, rentDate));
		}

	}

	public void findAllLibrarysWithBook(Book book2) {
		Vector < Library > foundLibs = this.ls.findBookInAllLibraries(book2);

		System.out.println(book2.bookName + " can be found at the following libraries: ");
		for (Library l: foundLibs) {
			System.out.println(l.libraryName);
		}
	}
	public Vector < Library > findAvailableRental(Book bil) {
		Vector < Library > allLibraries = new Vector < Library > ();
		System.out.println("\n" + bil.bookName + " is available for rent at the following libraries: ");

		for (int i = 0; i < this.ls.numberOfLibraries; i++) {
			if (this.ls.libraries[i].canRent(bil)) {
				allLibraries.addElement(this.ls.libraries[i]);
				System.out.println(Helper.printAvailable(bil, Helper.getCurrentDate(), this.ls.libraries[i]));
			}
		}
		return allLibraries;
	}

		public void findNextAvailableDate(Book book3){
			Library library3 = this.ls.isThereBookInLibraries(book3);
	      
	        String result = "This book is: \n";

	        if(book3.isRented(library3)){
	            System.out.println(Helper.printUnavailable(book3, Helper.getCurrentDate() + ". \nAvailable for rent on: " + book3.availableDate(library3)));
	            result += "   Rented \n";
     
	            if(book3.isBookOverdue()) {
	            }
	        }else{
	            System.out.println(Helper.printAvailable(book3, Helper.getCurrentDate(), library3));
	            result += "   Available \n";
	        }
	        System.out.println(result);

	}
	public void calculateMaxValueTag() {

		for (Library lib: ls.libraries) {
			int maxVal = 0;
			maxVal += lib.findMaximumValueTag();
			System.out.println("Max value tag in " + lib.libraryName + " is: " + maxVal);
		}

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		result = prime * result + ((ls == null) ? 0 : ls.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Manager))
			return false;
		Manager other = (Manager) obj;
		if (library == null) {
			if (other.library != null)
				return false;
		} else if (!library.equals(other.library))
			return false;
		if (ls == null) {
			if (other.ls != null)
				return false;
		} else if (!ls.equals(other.ls))
			return false;
		return true;
	}
}