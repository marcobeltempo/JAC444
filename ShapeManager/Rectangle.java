package Assignment1;

import java.text.DecimalFormat;

public class Rectangle extends Shapes {

	private double length;
	private double width;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	public Rectangle(double length, double width) throws Exception {

		if (length > 0.00 && width > 0.00) {

			this.length = length;


		} else {
			throw new Exception("Invalid length: " + df2.format(length) + " and width " + df2.format(width));

		}
	}

	/**
	 * Returning a string of the variable in the circle
	 * 
	 * @return a String indicating the radius of the circle
	 */
	@Override
	public String toString() {

		String s;

		s = "Rectangle {l=" + df2.format(length) + " w=" + df2.format(this.width) + " perimeter= " + df2.format(getPerimeter()) + "}\n";

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
		if (!(obj instanceof Rectangle))
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	/**
	 * Getting the perimeter of the Rectangle
	 * 
	 * @return a double indicating the perimeter of the shape
	 */

	public double getPerimeter() {

		return 2 * length + 2 * width;
	}

}
