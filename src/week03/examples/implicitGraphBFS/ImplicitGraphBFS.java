package week03.examples.implicitGraphBFS;

import java.util.*;

public class ImplicitGraphBFS {
    static int[][] grid;
    static boolean[][] visited;
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
        bfs(0, 0);
    }

    public static boolean isValid(int row, int col) {
        return (row>=0 && row<rowLength)&&(col>=0 && col<colLength);
    }

    public static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0 ;i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isValid(nx, ny) && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
