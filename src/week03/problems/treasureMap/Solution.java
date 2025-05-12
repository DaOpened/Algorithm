package week03.problems.treasureMap;

import java.util.*;

class Solution {
    static boolean[][] maze;
    static boolean[][][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1 ,1};

    public int solution(int n, int m, int[][] hole) {
        maze = new boolean[n][m];
        visited = new boolean[n][m][2];

        // 함정 정보 저장
        // maze[row][col] == true 면 함정
        for(int[] x : hole) {
            maze[x[0]-1][x[1]-1] = true;
        }

        // visited[row][col][shoeUsed]
        // shoeUsed 0이면 사용안함, 1이면 사용
        // 큐에는 {row, col, distance, shoeUsed} 순으로 저장
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0, 0});
        visited[0][0][0] = true;

        // dfs 이용
        // 1. 다음으로 이동
        // 2. 신발 사용안했다면 사용
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0], curY = cur[1], dist = cur[2], shoe = cur[3];

            if((curX == n-1) && (curY == m-1)) {
                return dist;
            }

            for(int i = 0; i < 4 ; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if((0<=nx && nx<n) && (0<=ny && ny<m)) {
                    if(!visited[nx][ny][shoe] && !maze[nx][ny]) {
                        q.offer(new int[] {nx, ny, dist+1, shoe});
                        visited[nx][ny][shoe] = true;
                    }
                }
            }

            if(shoe == 0) {
                for(int i = 0; i < 4 ; i++) {
                    int nx = curX + 2 * dx[i];
                    int ny = curY + 2 * dy[i];

                    if((0<=nx && nx<n) && (0<=ny && ny<m)) {
                        if(!visited[nx][ny][1] && !maze[nx][ny]) {
                            q.offer(new int[] {nx, ny, dist+1, 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
