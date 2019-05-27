package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphL {
	int numVertices;
	LinkedList<Integer>[] adjList;
	
	GraphL(int numVertices) {
		this.numVertices = numVertices;
		adjList = new LinkedList[numVertices];
		
		for (int i = 0; i < numVertices; i++)
			adjList[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int s, int d) {
		adjList[s].add(d);
	}
	
	public List<Integer> dfs(int s) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[numVertices];
		stack.push(s);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			result.add(cur);
			visited[cur] = true;
			for (Integer i : adjList[cur])
				if (!visited[i])
					stack.push(i);
			
		}
		return result;
	}
	
	public List<Integer> dfsRecursive(int s) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[numVertices];
		dfsRecursiveHelper(s, result, visited);
		return result;
	}
	
	public void dfsRecursiveHelper(int s, List<Integer> result, boolean[] visited) {
		visited[s] = true;
		result.add(s);
		for (Integer i : adjList[s])
			if (!visited[i])
			dfsRecursiveHelper(i, result, visited);
	}
	
	public List<Integer> bfs(int s) {
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[numVertices];

		q.add(s);
		while(!q.isEmpty()) {
			int cur = q.remove();
			visited[cur] = true;
			result.add(cur);
			for (Integer i : adjList[cur]) {
				if (!visited[i])
					q.add(i);
			}
		}
		
		return result;
	}
	
	public boolean isBipartite() {
		int[] groups = new int[numVertices];
		Arrays.fill(groups, -1);
		for (int i = 0; i < numVertices; i++) {
			if (groups[i] == -1 && !isBipartiteHelper(i, groups))
				return false;
		}
		
		return true;
	}
	
	public boolean isBipartiteHelper(int s, int[] groups) {		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		groups[s] = 0;
		
		while(!q.isEmpty()) {
			Integer cur = q.poll();
			for (Integer i : adjList[cur]) {
				if (i == cur || groups[i] == groups[cur])
					return false;
				else {
					q.add(i);
					groups[i] = (groups[s] + 1) % 2;
				}
			}
		}
		return true;
	}
}
