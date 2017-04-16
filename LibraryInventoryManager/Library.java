package Assignment2;

import java.util.Vector;
import java.util.zip.DataFormatException;

public class Library implements MaxTagValue {

	String libraryName;
	Vector <Book> books;

	// ctr. that takes as param only the libraryName
	public Library(String libraryName) {

		this.libraryName = libraryName;
		books = new Vector < Book > ();
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public Vector < Book > getBooks() {
		return books;
	}

	public void setBooks(Vector < Book > books) {
		this.books = books;
	}
	public boolean canRent(Book rb) {
		for (Book b: books) {
			if (b.equals(rb)) {
				if (!rb.equals(this)){
					return true;			
				}
			}
		}
		return false;
	}
	
	/**
	 * The method takes three parameters:
	 * 
	 * @param wanted - the desired book
	 * @param requestDate - the date requested
	 * @param dueDate - the due date
	 * @return boolean - true if book is available in this library from
	 *         requestDate up to dueDate
	 */
	public boolean rentRequest(Book wanted, String requestDate, String dueDate) {

		if (!wanted.isRented(this)) {
			return wanted.rentBook(requestDate, dueDate, this);
		}
		else {
			try {

				return (Helper.timeDifference(requestDate, dueDate) > 0);

			} catch(RentPeriodException e) {

				e.getMessage();
			}

			catch(DataFormatException d) {
				d.getMessage();

			}
		}
		return false;
	}
	
	// this method search all the books from a library
	public int findMaximumValueTag() {
		int maxElement = -100;
		for (Book book: books) {
			if (book.valueTag > maxElement) maxElement = book.valueTag;
		}
		return maxElement;
	}

	@Override
	public String toString() {
		return "Library [libraryName=" + libraryName + ", books=" + books + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((libraryName == null) ? 0 : libraryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! (obj instanceof Library)) return false;
		Library other = (Library) obj;
		if (books == null) {
			if (other.books != null) return false;
		} else if (!books.equals(other.books)) return false;
		if (libraryName == null) {
			if (other.libraryName != null) return false;
		} else if (!libraryName.equals(other.libraryName)) return false;
		return true;
	}

}