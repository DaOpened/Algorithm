package week03.maze.examples.implicitGraphDFS;

import java.util.*;

public class ImplicitGraphDFS {
    static boolean[][] visited;
    static int[][] grid;
    static int rowLength;
    static int colLength;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        grid = new int[][] {
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 1}
        };
       rowLength = grid.length;
       colLength = grid[0].length;
       visited = new boolean[rowLength][colLength];

       dfs(0, 0);
    }

    public static boolean isValid(int row, int col) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength)
            return false;
        return true;
    }

    public static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i = 0 ; i < 4 ; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];
            if(isValid(nr, nc) && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
