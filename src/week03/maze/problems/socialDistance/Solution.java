package week03.maze.problems.socialDistance;

import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);

        // dfs 이용
        // 1. P 찾기
        // 2. 가장 가까운 P와의 거리가 맨해튼 거리 2 초과 만족하는지 판단
        for( int placeNum = 0; placeNum < 5 ; placeNum++){
            // 그래프 생성
            char[][] grid = new char[5][5];
            for(int i = 0 ; i < 5; i++) {
                grid[i] = places[placeNum][i].toCharArray();
            }
            boolean[][] visited = new boolean[5][5];

            // 1. P 찾기
            for(int i = 0 ; i < 5 ; i++)  {
                for(int j = 0; j < 5; j++) {
                    if(grid[i][j] == 'P') {
                        // 2. 가장 가까운 P와 조건 만족하는지 판단
                        if(!dfs(grid, visited, i, j))
                            answer[placeNum] = 0;
                    }
                }
            }
        }
        return answer;
    }

    public boolean dfs(char[][] grid, boolean[][] visited, int row, int col) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {row, col, 0});
        visited[row][col] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];

            for(int i = 0 ; i < 4 ; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if((0 <= nx && nx < 5) && (0 <= ny && ny < 5)) {
                    if(grid[nx][ny] != 'X' && !visited[nx][ny]) {
                        if(grid[nx][ny] == 'P'){
                            return curD+1 > 2;
                        }
                        q.offer(new int[] {nx, ny, curD+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }


        return true;
    }
}