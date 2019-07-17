package leetcode;

import java.util.LinkedList;
import java.util.List;

public class WordLadder_127 {
	static class Graph {
		LinkedList<Integer>[] adjList;
		
		Graph(int numVertices) {
			adjList = new LinkedList[numVertices];
			
			for (int i = 0; i < numVertices; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int s, int d) {
			adjList[s].add(d);
		}
		
		public int getMinHops(int s, int d) {
			int result = 0;
			
			return result;
		}
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int result = 0;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
