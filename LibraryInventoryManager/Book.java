package Assignment2;

import java.util.zip.DataFormatException;

/**
 * @author Marco Beltempo 
 * 
 */
class Book {

	String bookName; // the book name
	int valueTag; // an integer between -100 and 100
	Library library; // the library having this book it its inventory
	RentSettings rs; // rent settings
	
	public Book(String bookName, int valueTag) {
		setBookName(bookName);
		setValueTag(valueTag);
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getValueTag() {
		return valueTag;
	}

	public void setValueTag(int valueTag) {
		this.valueTag = valueTag;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	// getter for RentSettings rs object
	public RentSettings getRs() {
		return rs;
	}

	// setter for RentSettings rs object
	public void setRs(RentSettings rs) {
		this.rs = rs;
	}

	/** This function 
	*@param rentDate - set rent dates if valid 
	*@param dueDate - set due date if valid
	*@return false if exception or invalid date,
	*@return rentDate > dueDate catch RentPeriodException and return false
	**/
	public boolean rentBook(String rentDate, String dueDate, Library library) {

		try {
			setLibrary(library);
			setRs(new RentSettings(rentDate, dueDate, library));

			return true;

		} catch(DataFormatException e) {

			System.err.println("The date entered is not valid. Correct format for date is (MM/DD/YYYY).");
			return false;

		} catch(RentPeriodException rent) {
			System.err.println("The rent period of the device is past the due date.");
			return false;
		}

	}

	// destroy the RentSettings object for this book
	public void returnBook(Library library) {
		if (this.library.equals(library)) {
			System.out.println("\nBook: " + getBookName() + " has been returned.");
			setRs(null);
			setLibrary(null);		
		}
	}

	// return the date when this book is available
	public String availableDate(Library library) {
		return rs == null ? Helper.getCurrentDate() : rs.dueDate;

	}

	// returns true if the current date is greater than the due date
	public boolean isBookOverdue() {
		try {
			if (Helper.timeDifference(Helper.getCurrentDate(), rs.getDueDate()) <= 0) {
				
                System.out.println(this.bookName() + " is overdue by " + Helper.timeDifference(this.rs.getDueDate(), this.rs.getDueDate()) + " days.");
                return true;
			}
		} catch(DataFormatException d) {
			System.out.println(d.getMessage());
		}
		catch(RentPeriodException r) {		

		}

		return false;
	}

	// returns true is the book is rented
	public boolean isRented(Library l) {

		if (this.library != null && this.library.equals(library)) return (rs != null ? rs.isBorrowed() : false);
		return false;
	}

	public String bookName() {
		return "(" + bookName + ", " + valueTag + ')';
	}

	@Override
	public String toString() {
		String str = "";

		if (library == null) {
			str = bookName();
		}
		else {
			str = "(" + bookName + ", " + valueTag + "=> " + library.libraryName + ") ";
		}
		if (rs != null) {
			str += " " + rs.toString();
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((library == null) ? 0 : library.hashCode());
		result = prime * result + ((rs == null) ? 0 : rs.hashCode());
		result = prime * result + valueTag;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (! (obj instanceof Book)) return false;
		Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null) return false;
		} else if (!bookName.equals(other.bookName)) return false;
		if (library == null) {
			if (other.library != null) return false;
		} else if (!library.equals(other.library)) return false;
		if (rs == null) {
			if (other.rs != null) return false;
		} else if (!rs.equals(other.rs)) return false;
		if (valueTag != other.valueTag) return false;
		return true;
	}

	// inner class that defines the rented period and book availability
	private class RentSettings {

		private String rentDate; // date when the item is requested
		private String dueDate; // date when the item must be returned
		private boolean borrowed = false; // true if the item is rented
		// default ctr
		private RentSettings() throws DataFormatException,
		RentPeriodException {

			setRentDate(null);
			setDueDate(null);
			setBorrowed(false);
		}

		// private ctr must throw DateFormatException and RentPeriodException
		private RentSettings(String rentDate, String dueDate, Library library)
		throws DataFormatException,
		RentPeriodException {

			setRentDate(rentDate);
			setDueDate(dueDate);
			setBorrowed(true);

		}
		public String getRentDate() {
			return rentDate;
		}

		public void setRentDate(String rentDate) {
			this.rentDate = rentDate;
		}

		public String getDueDate() {
			return dueDate;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

		public boolean isBorrowed() {
			return borrowed;
		}

		public void setBorrowed(boolean borrowed) {
			this.borrowed = borrowed;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (borrowed ? 1231 : 1237);
			result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
			result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (! (obj instanceof RentSettings)) return false;
			RentSettings other = (RentSettings) obj;
			if (!getOuterType().equals(other.getOuterType())) return false;
			if (borrowed != other.borrowed) return false;
			if (dueDate == null) {
				if (other.dueDate != null) return false;
			} else if (!dueDate.equals(other.dueDate)) return false;
			if (rentDate == null) {
				if (other.rentDate != null) return false;
			} else if (!rentDate.equals(other.rentDate)) return false;
			return true;
		}

		@Override
		public String toString() {
			return "RentSettings (" + Book.this.library.libraryName + getRentDate() + ", " + getDueDate() + ", " + isBorrowed() + ")";
		}

		private Book getOuterType() {
			return Book.this;
		}
	}
}