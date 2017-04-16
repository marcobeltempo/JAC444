package Assignment2;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class Helper {

/**
 * @author Marco Beltempo
 * This function searches the path argument for valid Library files
 * Files do not have to be listed individually
 * @param userDir users path for where they have stored the "...Library.txt" files
 * @return a multidimensional list that stores libraryNameList + fileNameList
 * 
 */
	public static List < List < String >> searchDirectory(String userDir) {

		List < List < String >> libraryList = new ArrayList < List < String >> (); // stores lists: libraryName + fileName
		List < String > libraryNameList = new ArrayList < String > (); // list of library names
		List < String > fileNameList = new ArrayList < String > (); // list of file names
		File[] libraryFiles = new File(userDir).listFiles();

		System.out.println("----------------------------------------------------------");
		System.out.println("Searching for valid library files...");
		System.out.println("----------------------------------------------------------");

		for (File lf: libraryFiles) {
			if (lf.isFile() && lf.getName().endsWith("Library.txt")) {

				fileNameList.add(lf.getName()); // save file name to the list
				libraryNameList.add(lf.getName().replaceAll("Library.txt", " Library")); // parse + save library name
			}
		}
		// add lists to multidimensional list
		libraryList.add(fileNameList);
		libraryList.add(libraryNameList);

		return libraryList;
	}

	public static boolean isValidDate(String date) {
		boolean valid = true;

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		formatter.setLenient(false);
		try {
			formatter.parse(date);
		} catch(ParseException e) {
			valid = false;
		}
		return valid;
	}

	public static void checkDate(String date) throws DataFormatException {

		if (!Helper.isValidDate(date)) {

			try {
				throw new DataFormatException("Invalid data format " + date + " it should be MM/dd/yyyy");
			} catch(DataFormatException e) {
				e.getMessage();
			}
		}
	}

	public static long timeDifference(String date1, String date2) throws DataFormatException,
	RentPeriodException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		if (!isValidDate(date1) || !isValidDate(date2)) {
			throw new DataFormatException();
		}

		Date d1 = null;
		Date d2 = null;
		long diffDays = 0;

		try {
			d1 = dateFormat.parse(date1);
			d2 = dateFormat.parse(date2);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();
			diffDays = diff / (24 * 60 * 60 * 1000);
			return diffDays;

		} catch(Exception e) {
			e.printStackTrace();
		}
		return diffDays;
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//get current date time with Date()
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String printAvailable(Book book, String rentDate, Library library) {
		return "Book (" + book.bookName + ", " + book.valueTag + ") is availble for rent on " + rentDate + " from the: " + library.libraryName;
	}

	public static String printUnavailable(Book book, String rentDate) {
		return "Book " + book + " is not availble for " + rentDate;
	}

	public static String printNonexistent(Book book) {
		return "\nSorry the following book: " + book + " does not exist.";
	}

}