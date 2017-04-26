package algs4.chapter1;

import java.awt.Color;

import org.junit.Test;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Question121 {
	
	
	@Test 
	public void test2(){
		
		StdOut.println( mystery("0123456789A"));
	}
	public static String mystery(String s) {
	    int N = s.length();
	    if (N <= 1) return s;
	    String a = s.substring(0, N/2);
	    String b = s.substring(N/2, N);
	    return mystery(b) + mystery(a);
	}
	
	@Test
	public void test(){
		
		double s=0.0,e=500.0;
		int n = 100;
		Point2D[] a = new Point2D[n];
		for(int i=0;i<n;i++){
			 a[i] = new Point2D(StdRandom.uniform(s,e),StdRandom.uniform(s,e));
		}
		StdDraw.setXscale(0,500);
		StdDraw.setYscale(0,500);
		StdDraw.setPenRadius(0.005);
		for (int i=0;i<n;i++){
			 Color color = new Color(StdRandom.uniform(16777216));
			 StdDraw.setPenColor(color);
			 StdDraw.point(a[i].x(), a[i].y());
		}
		
		
		
		Stopwatch stopWatch= new Stopwatch();
		
		Point2D ms = a[0];
		Point2D me = a[1];
		double minD = ms.distanceTo(me);
		
		for (int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i].distanceTo(a[j])<minD){
					ms = a[i];
					me = a[j];
					minD=a[i].distanceTo(a[j]);
				}
			}
		}
		StdOut.printf("distanceTo cost %.2f seconds\n", stopWatch.elapsedTime());
		stopWatch = new Stopwatch();
		ms = a[0];
		me = a[1];
        minD = ms.distanceSquaredTo(me);
		
		for (int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[i].distanceSquaredTo(a[j])<minD){
					ms = a[i];
					me = a[j];
					minD=a[i].distanceSquaredTo(a[j]);
				}
			}
		}
		StdOut.printf("distanceSquaredTo cost %.2f seconds\n", stopWatch.elapsedTime());
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(ms.x(), ms.y());
		StdDraw.point(me.x(), me.y());
		StdDraw.line(ms.x(), ms.y(),me.x(), me.y());
		StdOut.printf("%.2f seconds\n", stopWatch.elapsedTime());
	}
}
