import java.util.Scanner;

/**
 * Creates flight objects that contain an airline name, flight number, departure location, and destination.
 * Contains methods that can read flight data from the user and determine whether there is a stop over 
 * between two flights.
 * @fileName Flight.java
 * @author Julia McDonald
 * @date September 18, 2017
 */
public class Flight {
	private String airline;
	private int flNum;
	private String from;
	private String to;
	
	/**
	 * The Flight constructor reads and initializes all data.
	 * @param airline - The name of the airline
	 * @param flNum - The flight number
	 * @param from - The city of origin
	 * @param to - The city of destination
	 */
	public Flight( String airline, int flNum, String from, String to ) {
		this.airline = airline;
		this.flNum = flNum;
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Getter for airline instance variable.
	 * @return The airline name
	 */
	public String getAirline() {
		return airline;
	}
	
	/**
	 * Setter for airline instance variable.
	 * @param airline - The name of the airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	/**
	 * Getter for flightNum instance variable.
	 * @return - The flight number
	 */
	public int getFlightNumber() {
		return flNum;
	}
	
	/**
	 * Setter for flightNum instance variable.
	 * @param flNum - The number representing the flight
	 */
	public void setFlightNumber(int flNum) {
		this.flNum = flNum;
	}
	
	/**
	 * Getter for origin instance variable.
	 * @return The origin city of the flight
	 */
	public String getOrigin() {
		return from;
	}
	
	/**
	 * Setter for origin instance variable.
	 * @param fromCity - The origin city of the flight
	 */
	public void setOrigin(String fromCity) {
		from = fromCity;
	}
	
	/**
	 * Getter for destination instance variable
	 * @return - The destination city of the flight
	 */
	public String getDestination() {
		return to;
	}
	
	/**
	 * Setter for destination instance variable
	 * @param toCity - The destination city of the flight
	 */
	public void setDestination(String toCity) {
		to = toCity;
	}
	
	/**
	 * Checks if the destination of f1 is the same as origin of f2.
	 * @param f1 - First flight
	 * @param f2 - Second flight
	 * @return Whether first flight stops at the origin of the second flight
	 */
	public static boolean stopOver(Flight f1, Flight f2) {
		return f1.getDestination().equals(f2.getOrigin());
	}
	
	/**
	 * Formats the properties of the flight into a nice looking string.
	 * @override toString in class Object
	 * @return The object state
	 */
	public String toString() {
		return airline + " " + flNum + "\n" + from + " - " + to;
	}
	
	/**
	 * Reads the details of a Flight. Returns the Flight object. Used in main(). 
	 * @param s - the Scanner object to be used for reading user input
	 * @return The flight as entered by the user
	 */
	public static Flight readFlight(Scanner s) {
		System.out.println( "Airline?" );
		String air = s.nextLine();
		
		System.out.println( "Flight Number?" );
		int flightNum = s.nextInt();
		s.nextLine();
		
		System.out.println( "Where from?" );
		String origin = s.nextLine();
		
		System.out.println("Where to?");
		String destination = s.nextLine();
		
		return new Flight( air, flightNum, origin, destination );
	}
	
	/**
	 * Driver method, used to test the class.
	 */
	public static void main(String[] args) {
		System.out.println( "Flight 1:");
		Scanner sc = new Scanner( System.in );
		Flight f1 = readFlight( sc );
		
		System.out.println( "Flight 2:");
		Flight f2 = readFlight( sc );
		
		System.out.println( "Flight 3:");
		Flight f3 = readFlight( sc );
		
		System.out.println( "\n" + f1 + "\n\n" + f2 + "\n\n" + f3 + "\n" );
		
		System.out.println( "Is there a stop over between flights 1 and 2?");
		System.out.println( stopOver( f1, f2 ) ? "yes" : "no" );
		
		System.out.println( "Is there a stop over between flights 1 and 3?");
		System.out.println( stopOver( f1, f3 ) ? "yes" : "no" );
	}
}
