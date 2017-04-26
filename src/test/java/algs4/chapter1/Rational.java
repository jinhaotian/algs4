package algs4.chapter1;

import org.junit.Test;

import edu.princeton.cs.algs4.StdOut;

public class Rational {

	private long numerator;
	private long denominator;
	
	/**
	 * Rational number
	 * @param numerator
	 * @param  denominator
	 * @exception ArithmeticException
	 */
	public Rational(long numerator, long denominator){
		
		//denominator could not bee 0;
		if(denominator == 0){
			throw new ArithmeticException("denominator is zero");
		}
		
		//reduce fraction
		long d = Rational.gcd(numerator,denominator);
		this.numerator = numerator/d;
		this.denominator = denominator/d;
		
		//negative
		if(this.denominator<0){
			this.numerator=-this.numerator;
			this.denominator=-this.denominator;
		}
	}
	
	// selector
	public long numerator() { return this.numerator; }
	public long denominator() { return this.denominator; }
	
	// return String
	public String toString(){
		return this.numerator + "/" + this.denominator;
	}
	
	// is this Rational object equal to other?
  
	
	// equals
	public boolean equals(Object that){
		if(this == that) return true;
		if(that == null) return false;
		if(that.getClass() != this.getClass()) return false;
		Rational other = (Rational) that; 
		return this.compareTo(other) == 0;
	}
	
	// return { -1, 0, 1} if this < that, this = that, this > that 
    public  int compareTo(Rational that) {
		long n = this.numerator * that.denominator;
		long d = this.denominator * that.numerator;
		if (n < d) return -1;
		if (n > d) return +1;
		else return 0;
	}
    
    
    // test client
    public static void main(String args[]){
    	Rational r1,r2;
    	r1 = new Rational(9,15);
    	r2 = new Rational(15,9);
    	
    	StdOut.println(r1);
    	StdOut.println(r2);
    	
    	StdOut.println(Rational.square(100));
    	StdOut.println(Rational.square(1000));
    	StdOut.println(Rational.square(10000));
    	StdOut.println(Rational.square(100000));
    	StdOut.println(Rational.square(111222333444l));
    }

	// calculate gcd
	private static  long gcd(long n1, long n2){
		if( n1 < 0) n1 = -n1;
		if( n2 < 0) n2 = -n2;
		if( n2 == 0) {
			return n1;
		}else{
		    return gcd(n2, n1 % n2);	
	    }
	}
	
	// calculate square
	public static double square(long n){
		double delta = 0.0000001 * n;
		return square(n, n, delta);
	}
	
	private static double square(long n, double guess, double delta){
		if(Math.abs((n/guess - guess)) < delta) return guess;
		else return square(n, (n/guess + guess)/2, delta);
	}
}
