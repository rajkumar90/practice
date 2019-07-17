package leetcode;

import java.util.PriorityQueue;

public class KClosestPoints {
	private class Point {
        public int x, y;
        public double distance;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            distance = computeDistance(x, y);
        }
        
        public double computeDistance(int x, int y) {
            return Math.sqrt(x*x + y*y);
        }
    }
        
    public int[][] kClosest(int[][] points, int k) {
        int numPoints = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a,b) -> Double.compare(b.distance, a.distance));
        for (int i = 0; i < numPoints; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            pq.add(p);
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
