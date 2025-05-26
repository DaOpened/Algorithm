package week05.review.marvelMoving;

import java.util.*;
import java.io.*;

class Main {
    // 상, 하, 좌, 우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        int rRow = 0, rCol = 0, bRow = 0, bCol = 0; // 구슬 위치
        int hRow = 0, hCol = 0; // 구멍 위치
        int check = 0;
        // 보드 생성
        for(int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rRow = i;
                    rCol = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bRow = i;
                    bCol = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'O') {
                    hRow = i;
                    hCol = j;
                }
            }
        }

        System.out.println(hRow+" "+hCol);
        Deque<List<Integer>> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        q.offer(Arrays.asList(rRow, rCol, bRow, bCol, 0));
        visited[rRow][rCol][bRow][bCol] = true;

        while(!q.isEmpty()) {
            List<Integer> cur = q.poll();
            System.out.println("빨강 : ("+cur.get(0)+", "+cur.get(1)+") 파랑 : ("+cur.get(2)+", "+cur.get(3)+") "+cur.get(4));

            // 빨간 구슬이 구멍에 도달한 경우
            if(cur.get(0) == hRow && cur.get(1) == hCol) {
                //bw.write(1);
                check = 1;
                System.out.println("구멍도달");
                break;
            }

            int cRedx = cur.get(0), cRedy = cur.get(1);
            int cBluex = cur.get(2), cBluey = cur.get(3);

            // 1. 두 구슬 동시에 이동 가능한 곳까지 같이 이동
            // 2. 파란 구슬이 구멍에 다다르면 다른 방향으로
            // 3. 더 갈 수 있는 구슬은 더 보냄
            for(int i = 0; i < 4 ; i++) {
                // 구슬 이동 가능한 경우
                if(board[cRedx+dx[i]][cRedy+dy[i]] == '.' || board[cBluex+dx[i]][cBluey+dy[i]] == '.') {
                    int nRedx = cRedx;
                    int nRedy = cRedy;
                    int nBluex = cBluex;
                    int nBluey = cBluey;
                    // 1. 두 구슬 동시에 이동 가능한 곳까지 같이 이동
                    while (board[nRedx + dx[i]][nRedy + dy[i]] == '.' && board[nBluex + dx[i]][nBluey + dy[i]] == '.') {
                        nRedx += dx[i];
                        nRedy += dy[i];
                        nBluex += dx[i];
                        nBluey += dy[i];
                    }

                    // 2. 파란 구슬이 구멍에 다다르면 다른 방향으로
                    if(board[nBluex+dx[i]][nBluey+dy[i]] == 'O') {
                        //System.out.println("파랑 구멍");
                        continue;
                    }

                    if(board[nRedx+dx[i]][nRedy+dy[i]] == 'O') {
                        //check = 1;
                        System.out.println("빨강 구멍 임박");
                        nRedx+=dx[i];
                        nRedy+=dy[i];
                    }

                    // 3. 더 갈 수 있는 구슬은 더 보냄
                    // 3-1. 빨간 구슬이 더 갈 수 있는 경우
                    if(board[nRedx+dx[i]][nRedy+dy[i]] == '.') {
                        board[nBluex][nBluey] = 'B';
                        while(board[nRedx+dx[i]][nRedy+dy[i]] == '.') {
                            nRedx += dx[i];
                            nRedy += dy[i];
                        }
                        board[nBluex][nBluey] = '.';
                    }

                    // 3-2. 파란 구슬이 더 갈 수 있는 경우
                    else if(board[nBluex+dx[i]][nBluey+dy[i]] == '.') {
                        board[nRedx][nRedy] = 'R';
                        while(board[nBluex+dx[i]][nBluey+dy[i]] == '.') {
                            nBluex += dx[i];
                            nBluey += dy[i];
                        }
                        board[nRedx][nRedy] = '.';
                    }

                    if (cur.get(4) < 10 && !visited[nRedx][nRedy][nBluex][nBluey]) {
                        q.offer(Arrays.asList(nRedx, nRedy, nBluex, nBluey, cur.get(4) + 1));
                        //System.out.println("빨강 : ("+nRedx+", "+nRedy+") 파랑 : ("+nBluex+", "+nBluey+")");
                        visited[nRedx][nRedy][nBluex][nBluey] = true;
                    }
                }
            }
        }
        //bw.write(1);
        System.out.println(check);
        //bw.flush();
    }
}

