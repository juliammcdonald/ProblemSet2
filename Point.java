import java.util.Scanner;

/**
 * This class keeps track of an x coordinate and a y coordinate on the Cartesian plane and 
 * determines the distance between two points and if three points are equidistant.
 * @fileName Point.java
 * @author Julia McDonald
 * @date September 18, 2017
 */
public class Point {
	private static final double TOLERANCE = 0.01;
	private double x;
	private double y;
	
	/**
	 * Given two doubles, it creates a Point instance.
	 * @param xCoord - The x-coordinate of this point
	 * @param yCoord - The y-coordinate of this point
	 */
	public Point( double xCoord, double yCoord ) {
		x = xCoord;
		y = yCoord;
	}
	
	/**
	 * Returns the x-coordinate of this point.
	 * @return The x-coordinate of this point
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x-coordinate of this point.
	 * @param newX - The new x-coordinate of this point
	 */
	public void setX( double newX ) {
		x = newX;
	}
	
	/**
	 * Returns the y-coordinate of this point.
	 * @return The y-coordinate of this point
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y-coordinate of this point.
	 * @param newY - The new y-coordinate of this point
	 */
	public void setY( double newY ) {
		y = newY;
	}
	
	/**
	 * Finds and returns the distance between this point and the input one.
	 * @param other - The other point
	 * @return The distance between this point and the one defined by the input values
	 */
	public double findDistance( Point other ) {
		return Math.sqrt( Math.pow( x - other.getX(), 2) + 
				Math.pow( y - other.getY(), 2));
	}
	
	/**
	 * Finds the distance between this point and the input one.
	 * Return true if the two points are practically equidistant, i.e. their distance is
	 * 	less than TOLERANCE, false otherwise.
	 * @param p2 - The second point
	 * @param p3 - the third point
	 * @return true if the second point and the third point have -practically- the same 
	 * 			distance from this point
	 */
	public boolean areEquidistant(Point p2, Point p3) {
		return Math.abs(findDistance( p2 ) - findDistance( p3 )) < TOLERANCE &&
				Math.abs(p2.findDistance( p3 ) - findDistance( p2 )) < TOLERANCE;
	}
	
	/**
	 * Reads from the input scanner, two double numbers, to define a Point. It's used 
	 * 	within the main().
	 * @param s - the Scanner object to be used for reading user input
	 * @return The point entered by the user
	 */
	public static Point readPoint( Scanner s ) {
		System.out.println( "Enter x-coordinate:" );
		double newX = s.nextDouble();
		System.out.println( "Enter y-coordinate:");
		double newY = s.nextDouble();
		return new Point( newX, newY );
	}
	
	/**
	 * Formats the properties of the point into a nice looking string.
	 * @override toString in class Object
	 * @return The object state
	 */
	public String toString() {
		return "( " + x + ", " + y + " )" ;	
	}
	
	/**
	 * Driver method, used to test the class.
	 */
	public static void main( String[] args ) {
		Point p = new Point( 1, 3 );
		Point q = new Point( 2, 9 );
		Point r = new Point( 13, 4 );
		Point n = new Point( -1, -15 );
		
		System.out.println( p.getX() + " " + p.getY() + " " + p );
		p.setX( 3 );
		p.setY( 4 );
		System.out.println( p.getX() + " " + p.getY() + " " + p);
		
		System.out.println( p.findDistance(q) + " " + p.findDistance(r) + " " + 
							q.findDistance(r) + " " + p.findDistance(p));
		
		System.out.println( p.areEquidistant( q, n ));
		p = new Point( 0, 2.309);
		q = new Point( -2, -1.154);
		n = new Point( 2, -1.154);
		System.out.println( p.areEquidistant( q, n ));
		p = new Point( 0, 2.3);
		q = new Point( -2, -1.1);
		n = new Point( 2, -1.1);
		System.out.println( p.areEquidistant( q, n ));
		
		Scanner sc = new Scanner( System.in );
		System.out.println( readPoint( sc ) );
		System.out.println( readPoint( sc ) );
	}
}
