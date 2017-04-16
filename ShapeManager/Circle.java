package Assignment1;
import java.text.DecimalFormat;

/** This class creates a shape of type circle */
public class Circle extends Shapes {

	/** circle radius */
	private double radius;
	private static DecimalFormat df2 = new DecimalFormat(".##");

	/**
	 * Constructor accepts an double for the radius, throws exception if data is
	 * not valid
	 * 
	 * @throws Exception
	 * @radius radius A positive double representing the radius of the circle
	 */

	public Circle(double radius) throws Exception {

		if (radius > 0.00) {

			this.radius = radius;
			//System.out.println("Circle with a radius of " + this.radius + " succesfully created!");

		} else {
			throw new Exception("Invalid radius '" + df2.format(radius) + "' The radius must be a positive number.");

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

		s = "Circle {r=" + df2.format(this.radius) + " Perimeter= " + df2.format(getPerimeter()) + "}\n";

		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Circle))
			return false;
		Circle other = (Circle) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	/**
	 * Getting the perimeter of the circle
	 * 
	 * @return a double indicating the perimeter of the shape
	 */
	@Override
	public double getPerimeter(){ 
		
	 CirclePerimeter circumference = r -> 2 * Math.PI * r; 

	 double circlePerimeter = this.circleValue (2, circumference); 
	 return circlePerimeter;
	}
	
	  public double circleValue (double r,  CirclePerimeter c) {  return c.getPerimeter(r);  } 
	  
	  public interface CirclePerimeter{ double getPerimeter(double r); }

	
	
}
