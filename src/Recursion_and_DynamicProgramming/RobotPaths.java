package Recursion_and_DynamicProgramming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class RobotPaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	// Number of ways robot can get to (x,y) from (0,0) is (x + y) choose x ways (n choose r)
	// x + y because we need x steps to the right and y steps down to have our path to get to (x,y) from origin
	// x because to build a path, we need to move x times to move right out of a total of x + y moves
	// Book's solution
	/*public static getPath(int x, int y, ArrayList<Point>path){
		
		// If out of bounds or not available, return
		if (y < 0 || x < 0 || !isFree(x,y)){
			return false;
		}
		
		boolean isAtOrigin = (x == 0 && y == 0);
		
		// If there's a path from start to me, add my location
		if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)){
			
			Point p = new Point(x, y);
			path.add(p);
			return true;
		}
		
		return false;
	}*/
	
	// DP
	/*public static boolean getPath(int x, int y, ArrayList<Point> path, Hashtable<Point, Boolean> cache){
		// If out of bounds or not available, return
		if (y < 0 || x < 0 || !isFree(x,y)){
			return false;
		}
		
		Point p = new Point(x, y);
		
		// If we've already visited this cell, return
		if (cache.containsKey(p))
			return cache.get(p);
		
		boolean isAtOrigin = (x == 0 && y == 0);
		boolean success = false;
		
		// If there's a path from start to me, add my location
		if (isAtOrigin || getPath(x, y - 1, path, cache) || getPath(x - 1, y, path, cache)){
			path.add(p);
			success = true;
		}
		
		cache.put(p, success);
		return success;
	}*/
}
