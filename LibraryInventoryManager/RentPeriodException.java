package Assignment2;

//the exception should be used if rented period is defined wrongly
public class RentPeriodException extends Exception {

	public RentPeriodException() {

}

	public RentPeriodException(String message) {
		super(message);
	}
}