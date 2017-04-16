package Assignment1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.DecimalFormat;
/**
 * Last Name: Beltempo 
 * First Name: Marco 
 * Student ID:031028095 
 * Codeboard UserName: mabeltempo
 *
 */

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName = "Shapes.txt";
		List<Shapes> shapesList = new ArrayList<Shapes>();
		DecimalFormat df2 = new DecimalFormat(".##");

		System.out.println("------->JAC 444 Assignment 1 by Marco Beltempo <-------");

		shapesList.addAll(Shapes.buildShapesFromFile(fileName));

		System.out.println("-------> Task 1 ... <-------");

		System.out.println(shapesList.toString().replaceAll(",", ""));

		System.out.println("-------> Task 2 ... <-------");

		double max = 0, min = 0;
		int maxIndexCircle = 0, minIndexTriangle = 0;

		for (Shapes s : shapesList) {
			if (s.getClass().equals(Circle.class) && s.getPerimeter() > max) {
				max = s.getPerimeter();
				maxIndexCircle = shapesList.indexOf(s);
			}
		}
		min = max;
		for (Shapes s : shapesList) {
			if (s.getClass().equals(Triangle.class) && s.getPerimeter() < min) {
				min = s.getPerimeter();
				minIndexTriangle = shapesList.indexOf(s); // get index of shape
															// to
															// be deleted
			}
		}

		System.out.println("Succesfully removed: " + shapesList.get(minIndexTriangle).toString());

		System.out.println("Succesfully removed: " + shapesList.get(maxIndexCircle).toString());
		shapesList.remove(minIndexTriangle); // remove triangle from list
		shapesList.remove(maxIndexCircle); // remove circle from list

		System.out.println("------->Task 3 ... <-------");
	
		/**
		 * @param totalPerim 
		 * Holds total perimeter of Parallelogram objects
		 */
		double totalParallelogramPerim = 0;

		for (Shapes s : shapesList) {
			if (s.getClass().equals(Parallelogram.class))
				totalParallelogramPerim += s.getPerimeter();
		}

		System.out.println("Total Parallelogram Perimeter = " + df2.format(totalParallelogramPerim) + "\n");
		

		System.out.println("------->Task 4 ... <-------");
		

		Collections.sort(shapesList, (s1, s2) -> {

			int shapeName = s1.toString().compareTo(s2.toString());
			if (shapeName != 0) {
				return shapeName;
			} else {
				if (s1.getPerimeter() < s2.getPerimeter())
					return -1;
				else if (s1.getPerimeter() == s2.getPerimeter())
					return 0;
				else
					return 1;
			}
		});
		System.out.println(shapesList.toString().replaceAll(",", ""));
	}

}
