// 백준 192358번 (스타트 택시)
package week03.problems.startTaxi;

import java.util.*;
import java.io.*;

public class Main {
    static int rowLen;
    static int customerLen;
    static int fuel;
    static int[][] map;
    static int[][] customers;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rowLen = Integer.parseInt(st.nextToken());
        customerLen = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        // map 생성
        map = new int[rowLen][rowLen];

        for(int i = 0; i < rowLen; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < rowLen ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 고객 정보 저장
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken())-1;
        int startY = Integer.parseInt(st.nextToken())-1;

        customers = new int[customerLen][2];
        for(int i = 0 ; i < customerLen ; i++) {
            st = new StringTokenizer(br.readLine());

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            map[sx-1][sy-1] = (i+2);

            customers[i][0] = Integer.parseInt(st.nextToken())-1;
            customers[i][1] = Integer.parseInt(st.nextToken())-1;

        }

        while(customerLen > 0) {
            // 손님을 태우러 감
            int[] taxi = bfs(startX, startY, true);

            if (fuel < taxi[2] || taxi[2] == -1) {
                bw.write(-1 + "\n");
                bw.flush();
                return;
            }

            startX = taxi[0];
            startY = taxi[1];
            fuel -= taxi[2];

            // 손님을 태우고 도착지로 감
            taxi = bfs(startX, startY, false);
            map[startX][startY] = 0;
            if (fuel < taxi[2] || taxi[2] == -1) {
                bw.write(-1 + "\n");
                bw.flush();
                return;
            }
            startX = taxi[0];
            startY = taxi[1];
            fuel += taxi[2];
            customerLen--;
        }

        bw.write(fuel+"\n");
        bw.flush();
    }

    public static int[] bfs(int startX, int startY, boolean customer) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rowLen][rowLen];

        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        int p = map[startX][startY]-2;
        int min = 401;
        int minrow = 21;
        int mincol = 21;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curx = cur[0], cury = cur[1], dist = cur[2];

            if(customer && map[curx][cury] > 1) {
                if (dist <= min) {
                    min = dist;
                    if (curx < minrow) {
                        minrow = curx;
                        mincol = cury;
                    }
                } else {
                    break;
                }
            }

            if(!customer && curx == customers[p][0] && cury == customers[p][1]) {
                return new int[] {curx, cury, dist};
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if((0 <= nx && nx < rowLen) && (0 <= ny && ny < rowLen)) {
                    if(!visited[nx][ny] && map[nx][ny] != 1) {
                        q.offer(new int[]{nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        if(minrow != 21)
            return new int[] {minrow, mincol, min};

        return new int[] {-1, -1, -1};
    }
}