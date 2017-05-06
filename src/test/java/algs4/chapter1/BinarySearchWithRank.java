package algs4.chapter1;

import org.junit.Test;

public class BinarySearchWithRank {
	  public static int indexOf(int[] a, int key) {
	        int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	    }
	  public static int indexOf2(int[] a, int key) {
	        int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else {
	            	if(lo == hi) return mid;
	            	else hi=mid;
	            }
	        }
	        return -1;
	    }
	  public static int indexOf3(int[] a, int key) {
	        int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else {
	            	if (lo == hi) {
	            		return mid;
	            	} else if(lo<mid){
	            		lo=mid;
	            	}else{
	            		lo=mid+1;
	            	}
	            		
	            }
	        }
	        return -1;
	    }
	  
	  @Test
	  public void test(){
		  int[] keys = {1, 2, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6,7, 7, 8, 8,8};
		  
		  System.out.println(BinarySearchWithRank.indexOf(keys, 5));
		  System.out.println(BinarySearchWithRank.indexOf2(keys, 5));
		  System.out.println(BinarySearchWithRank.indexOf3(keys, 7));
	  }
}
