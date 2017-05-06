package algs4.chapter1;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * this class will use as client to practice usage of 
 * {@code Interval1D} 
 * @author hjin
 */
public class Exercises122 {
	public static void main(String args[]) {
		int n = 50;
		int range = 500;
		Interval1D[] intervals = new Interval1D[n];
		
		for (int i = 0; i < n; i++){
			int start = StdRandom.uniform(range);
			int end = StdRandom.uniform(start, range);
			intervals[i] = new Interval1D(start, end);
		}
		Arrays.sort(intervals, Interval1D.MIN_ENDPOINT_ORDER);
		for (int i = 0; i < n; i++){
			for (int j = i+1; j < n; j++) {
				if (intervals[i].intersects(intervals[j])) {
					StdOut.println("Intersect:" + intervals[i] + ", " + intervals[j]);
				}
			}
		}
		
	}
}
