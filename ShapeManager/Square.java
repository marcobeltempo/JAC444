 package Assignment1;
import java.text.DecimalFormat;

public class Square extends Shapes {
	
	/**
	 * @param length
	 */
	private double length;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	public Square(double length) throws Exception {

		if (length > 0) {

			this.length = length;
			// System.out.println("Square Successfully Created length: " +
			// length);

		} else {
			throw new Exception("Invalid Square length: " + df2.format(length));

		}
	}

	@Override
	public String toString() {

		String s;

		s = "Square{Length=" + df2.format(length) + " perimeter= " + df2.format(getPerimeter()) + "}\n";

		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Square))
			return false;
		Square other = (Square) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		return true;
	}

	/**
	 * Getting the perimeter of the square
	 * 
	 * @return a double indicating the perimeter of the shape
	 */

	public double getPerimeter() {

		return 4 * length;
	}

}
