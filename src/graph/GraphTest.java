package graph;

import java.util.Arrays;

public class GraphTest {
	public static void main(String args[]) {
//		GraphL g = new GraphL(5);
		
		 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
             {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
             {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
             {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
             {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
             {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
             {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
             {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
             {0, 0, 2, 0, 0, 0, 6, 7, 0} 
            }; 
            
		GraphM g = new GraphM(graph);
		System.out.println(Arrays.toString(g.shortestPath(0)));
	}
}