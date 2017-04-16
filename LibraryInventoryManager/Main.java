/**
 * 
 *@author Marco Beltempo
 *Codeboard UserName: mabeltempo
 *Course: JAC444-AA
 *Student Id: 031028095
 *Assignment - 2,3 
 * 
 */
package Assignment2;

public class Main {

	public static void main(String[] args) {

		Manager m = new Manager();

		/* TASK 1 - build libraries from files - at least two libraries */
		System.out.println("\n *" + " TASK 1 " + "*");
		m.setLs(new Libraries());

		/* TASK 2 - ask for a book that is not in any library inventory */
		System.out.println("*" + " TASK 2 " + "*");
		Book book1 = new Book("C++", 20);
		Book book2 = new Book("A First Course in Database Systems", 25);
		Book book3 = new Book("Ghosts", -4);
		Book book4 = new Book("Java Programming Languages", 20);
		Book book5 = new Book("Elon Musk", 12);
		m.TaskTwo(book1);

		/* TASK 3 
         *  ask for a book that is in a library inventory
         *  issue a rent request and print the book "Essentials of Database Management"
         *  issue the same rent request and print the book
         *  return the book to the library 
         *  issue the rent request with new dates and print the book
         */
		m.TaskThree(book2);

		/* TASK 4 - ask for the same book in all libraries
         * if you can find a library, rent the book from that library */
		System.out.println("\n\n *" + " TASK 4 " + "*");
		
		m.findAllLibrarysWithBook(book3);
		m.findAvailableRental(book3);
		

		m.findAllLibrarysWithBook(book4);
		m.findAvailableRental(book4);
		
		/* TASK 5 - calculate maximum value tag for each library */
		System.out.println("\n\n *" + " TASK 5 " + "*");
		m.calculateMaxValueTag();
		
		/* TASK 6 - inquire about a book - it is available? when does it become available, etc. */
		System.out.println("\n\n *" + " TASK 6 " + "*");

		m.findNextAvailableDate(book2);
		m.findNextAvailableDate(book4);
		m.findNextAvailableDate(book5);
		
		
		
		
	}
}