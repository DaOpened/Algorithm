package week03.problems.mazeEscape;

import java.util.*;

class Solution {
    static char[][] grid;
    static boolean[][] lvisited;
    static boolean[][] evisited;
    static int rowLen;
    static int colLen;
    static int[] dx = {-1, 1, 0 , 0};
    static int[] dy = {0, 0, -1, 1};
    static int startX, startY;
    static int leverX, leverY;
    static int exitX, exitY;

    public int solution(String[] maps) {
        int answer = 0;
        rowLen = maps.length;
        colLen = maps[0].length();

        lvisited = new boolean[rowLen][colLen];
        evisited = new boolean[rowLen][colLen];

        // 미로 생성
        grid = new char[rowLen][colLen];

        for(int i = 0; i < rowLen ; i++) {
            grid[i] = maps[i].toCharArray();

            if(maps[i].contains("S")) {
                startX = i;
                startY = maps[i].indexOf("S");
            }

            if(maps[i].contains("L")) {
                leverX = i;
                leverY = maps[i].indexOf("L");
            }

            if(maps[i].contains("E")) {
                exitX = i;
                exitY = maps[i].indexOf("E");
            }
        }

        // 출구 -> 레버 최단거리 (bfs)
        Queue<int[]> lq = new LinkedList<>();

        lq.offer(new int[] {startX, startY, 0});
        lvisited[startX][startY] = true;

        while(!lq.isEmpty()) {
            int[] cur = lq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];

            if(curX == leverX && curY == leverY) {
                answer += curD;
                break;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if((0 <= nx && nx < rowLen) && (0 <= ny && ny < colLen)) {
                    if(grid[nx][ny] != 'X' && !lvisited[nx][ny]) {
                        lq.offer(new int[] {nx, ny, curD+1});
                        lvisited[nx][ny] = true;
                    }
                }
            }
        }

        // 레버까지 도달할 수 없는 경우 얼리 리턴
        if(answer == 0) {
            return -1;
        }

        // 레버 -> 출구까지 (bfs)
        Queue<int[]> eq = new LinkedList<>();

        eq.offer(new int[] {leverX, leverY, 0});
        evisited[leverX][leverY] = true;

        while(!eq.isEmpty()) {
            int[] cur = eq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];

            if(curX == exitX && curY == exitY) {
                return answer + curD;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if((0 <= nx && nx < rowLen) && (0 <= ny && ny < colLen)) {
                    if(grid[nx][ny] != 'X' && !evisited[nx][ny]) {
                        eq.offer(new int[] {nx, ny, curD+1});
                        evisited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
