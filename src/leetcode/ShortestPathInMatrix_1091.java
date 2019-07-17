package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathInMatrix_1091 {
    class Node {
        int i, j, dist;
        Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1)
            return -1;
        
        boolean visited[][] = new boolean[grid.length][grid.length];
        Queue<Node> q = new LinkedList<Node>();
        int x[] = {0,0,-1,-1,-1,1,1,1};
        int y[] = {-1,1,0,1,-1,0,-1,1};
        
        q.add(new Node(0,0,0));
        int c = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.i][cur.j] = true;
            for (int i = 0; i < 8; i++) {
                int nextX = cur.i + x[i];
                int nextY = cur.j + y[i];
                
                if (nextX == grid.length - 1 && nextY == grid.length -1)
                    return cur.dist + 2;
                System.out.println(c++);
                if (isSafe(nextX, nextY, grid) && !visited[nextX][nextY]) {
                    q.add(new Node(nextX, nextY, cur.dist + 1));
                }
            }
        }
        
        return -1;
    }
    
    boolean isSafe(int x, int y, int[][] grid) {
        if (x >=0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 0)
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
    	ShortestPathInMatrix_1091 s = new ShortestPathInMatrix_1091();
    	int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
		System.out.println(s.shortestPathBinaryMatrix(grid));
    }
}