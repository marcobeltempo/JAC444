package Assignment1;

import java.text.DecimalFormat;

public class Triangle extends Shapes {

	private double a;
	private double b;
	private double c;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	public Triangle(double a, double b, double c) throws Exception {

		if (a < 0 || b < 0 || c < 0) {

			throw new Exception("Triangle dimensions must be positive integers.");
		} else {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	@Override
	public String toString() {

		String s = "Triangle {Side a:" + df2.format(this.a) + " Side b:" + df2.format(this.b) + " Side c:" + df2.format(this.c) + " Perimeter: "
				+ df2.format(getPerimeter()) + "}\n";
		return s;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Triangle))
			return false;
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		return true;
	}

	/**
	 * Getting the perimeter of the Triangle
	 * 
	 * @return a double indicating the perimeter of the shape
	 */

	public double getPerimeter() {

		return a + b + c;
	}

}
