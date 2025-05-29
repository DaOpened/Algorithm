package week05.review.marvelMoving;

import java.util.*;
import java.io.*;

class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int redX = 0, redY = 0;
        int blueX = 0, blueY = 0;
        int holeX = 0, holeY = 0;

        char[][] maze = new char[N][M];
        for(int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0; j < M ; j++) {
                char c = line.charAt(j);
                if(c == 'R') {
                    redX = i;
                    redY = j;
                    c = '.';
                } else if (c == 'B') {
                    blueX = i;
                    blueY = j;
                    c = '.';
                } else if (c == 'O') {
                    holeX = i;
                    holeY = j;
                }
                maze[i][j] = c;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[redX][redY][blueX][blueY] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {redX, redY, blueX, blueY, 0});

        String answer = "0";
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println(cur[0] + " " + cur[1]+ " /  " + cur[2]+ " " + cur[3]+" / "+cur[4]);
            if(cur[4] > 10) {
                break;
            }

            if(cur[0] == holeX && cur[1] == holeY) {
                answer = "1";
                break;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nRedX = cur[0];
                int nRedY = cur[1];
                int nBlueX = cur[2];
                int nBlueY = cur[3];

                if(maze[nRedX+dx[i]][nRedY+dy[i]] != '#' || maze[nBlueX+dx[i]][nBlueY+dy[i]] != '#') {
                        while(maze[nRedX+dx[i]][nRedY+dy[i]] == '.' && maze[nBlueX+dx[i]][nBlueY+dy[i]] == '.') {
                            nRedX += dx[i];
                            nRedY += dy[i];
                            nBlueX += dx[i];
                            nBlueY += dy[i];
                        }

                        while(maze[nRedX+dx[i]][nRedY+dy[i]] != '#') {
                            if(nRedX+dx[i] == nBlueX && nRedY+dy[i] == nBlueY){
                                break;
                            }
                            nRedX += dx[i];
                            nRedY += dy[i];
                            if(nRedX == holeX && nRedY == holeY){
                                break;
                            }
                        }

                        boolean isBlueHole = false;
                        while(maze[nBlueX+dx[i]][nBlueY+dy[i]] != '#') {
                            if(nBlueX+dx[i] == holeX && nBlueY+dy[i] == holeY) {
                                isBlueHole = true;
                                break;
                            }

                            if(nBlueX+dx[i] == nRedX && nBlueY+dy[i] == nRedY) {
                                break;
                            }
                            nBlueX += dx[i];
                            nBlueY += dy[i];
                        }
                        //System.out.println(nRedX+" "+nRedY+" / "+nBlueX+" "+nBlueY);

                        if(!isBlueHole && !visited[nRedX][nRedY][nBlueX][nBlueY]) {
                            q.offer(new int[] {nRedX, nRedY, nBlueX, nBlueY, cur[4]+1});
                            visited[nRedX][nRedY][nBlueX][nBlueY] = true;
                        }
                    }

            }
        }

        bw.write(answer);
        bw.flush();
    }
}