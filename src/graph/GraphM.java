package graph;

import java.util.Arrays;
import java.util.List;

public class GraphM {
	int numVertices;
	int[][] adjMatrix;
	
	GraphM(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new int[numVertices][numVertices];
	}
	
	GraphM(int[][] arr) {
		this.numVertices = arr.length;
		this.adjMatrix = arr;
	}
	
	public void addNode(int s, int d) {
		adjMatrix[s][d] = 1;
	}
	
	public void addNode(int s, int d, int weight) {
		adjMatrix[s][d] = weight;
	}
	
	int[] shortestPath(int s) {
		int[] shortestDist = new int[numVertices];
		Arrays.fill(shortestDist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[numVertices];
		shortestDist[s] = 0;
		
		for (int i = 0; i < numVertices; i++) {
			int minIndex = getMinIndex(visited, shortestDist);
			visited[minIndex] = true;
			
			for (int j = 0; j < numVertices; j++) {
				if (adjMatrix[minIndex][j] != 0 && !visited[j] && shortestDist[minIndex] != Integer.MAX_VALUE &&
						shortestDist[minIndex] + adjMatrix[minIndex][j] < shortestDist[j])
					shortestDist[j] = shortestDist[minIndex] + adjMatrix[minIndex][j];
			}
		}
		
		return shortestDist;
	}

	private int getMinIndex(boolean[] visited, int[] shortestDist) {
		int minDist = Integer.MAX_VALUE, minIndex = 0;
		for (int i = 0; i < numVertices; i++) {
			if (!visited[i] && shortestDist[i] < minDist) {
				minDist = shortestDist[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}

}
