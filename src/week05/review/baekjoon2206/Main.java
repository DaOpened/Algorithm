package week05.review.baekjoon2206;
// 백준 2206번: 벽 부수고 이동하기

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //while(true) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            map[i] = row.toCharArray();
        }

        String answer = "-1";

        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 1, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            //System.out.println(cur[0] + " " + cur[1] + " / " + cur[2]);
            if(cur[0] == N-1 && cur[1] == M-1) {
                answer = String.valueOf(cur[2]);
                break;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(map[nx][ny] == '0' && !visited[nx][ny][cur[3]]) {
                        q.offer(new int[] {nx, ny, cur[2]+1, cur[3]});
                        visited[nx][ny][cur[3]] = true;
                    }

                    if(cur[3] < 1) {
                        if(!visited[nx][ny][cur[3]+1] && map[nx][ny] == '1') {
                            q.offer(new int[] {nx, ny, cur[2]+1, cur[3]+1});
                            visited[nx][ny][cur[3]+1] = true;
                        }
                    }
                }
            }
        }
        bw.write(answer);
        bw.newLine();
        bw.flush();
    }//}
}
