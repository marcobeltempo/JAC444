/**
 * 
 */
package Assignment1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author marco
 *
 */
public abstract class Shapes {


	public static class CustomComparator implements Comparator<Shapes> {
		public int compare(Shapes s1, Shapes s2) {
			int NameComp = s1.getClass().getName().compareTo(s2.getClass().getName());

			if (NameComp == 0) {
				return Double.compare(s1.getPerimeter(), s2.getPerimeter());

			}
			return NameComp;
		}
	}

	//
	public abstract double getPerimeter();

	public static List<Shapes> buildShapesFromFile(String fileName) {

		String path = System.getProperty("user.dir");

		List<Shapes> shapes = new ArrayList<Shapes>();
		String s;

		try (BufferedReader br = new BufferedReader(new FileReader(path + "/src/Assignment1/test/" + fileName))) {

			int lineNumber = 0;
			while ((s = br.readLine()) != null) {
				String[] tok = s.split(",");
				String shapeName = tok[0];

				lineNumber++;

				try {
					switch (shapeName) {

					case "Circle":

						shapes.add(new Circle(Double.parseDouble(tok[1])));
						break;
					case "Rectangle":

						shapes.add(new Rectangle(Double.parseDouble(tok[1]), Double.parseDouble(tok[2])));
						break;
					case "Square":
						shapes.add(new Square(Double.parseDouble(tok[1])));
						break;

					case "Triangle":

						shapes.add(new Triangle(Double.parseDouble(tok[1]), Double.parseDouble(tok[2]),
								Double.parseDouble(tok[3])));
						break;

					case "Parallelogram":

						shapes.add(new Parallelogram(Double.parseDouble(tok[1]), Double.parseDouble(tok[2])));
						break;
					default:
						throw new Exception("A valid shape could not be built from row# " + lineNumber + "...");
					}
				} catch (Exception e) {

					System.out.println(e);
				}
			}

			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return shapes;
	}
}
