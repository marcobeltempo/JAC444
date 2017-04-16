package Assignment1;

import java.text.DecimalFormat;

public class Parallelogram extends Shapes {

	private double width;
	private double length;
	private double perim;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * @param length
	 * @param width
	 */
	public Parallelogram(double length, double width) throws Exception {

		if (length > 0 && width > 0) {

			this.length = length;
			this.width = width;

		} else {
			throw new Exception("Invalid Parallelogram length:" + df2.format(length) + " Width:" + df2.format(width));

		}
	}

	/**
	 * Returning a string of the variable in the Parallelogram
	 * 
	 * @return a String indicating the radius of the Parallelogram
	 */
	@Override
	public String toString() {

		String s;

		s = "Parallelogram {l=" + df2.format(length) + " w=" + df2.format(width) + "perimeter= " + df2.format(getPerimeter()) + "\n";

		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Parallelogram))
			return false;
		Parallelogram other = (Parallelogram) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	/**
	 * Getting the perimeter of the Parallelogram
	 * 
	 * @return a double indicating the perimeter of the shape
	 */

	public double getPerimeter() {
		perim = (2 * length) + (2 * width);
		return perim;
	}

	public interface CirclePerimeter {
		double getPerimeter(double radius);
	}

}
