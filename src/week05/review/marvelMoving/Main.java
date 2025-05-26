package week05.review.marvelMoving;

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        // 미로찾기 => BFS 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        int rRow = 0, rCol = 0, bRow = 0, bCol = 0; // 구슬 위치
        int hRow = 0, hCol = 0; // 구멍 위치

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

        // 상, 하, 좌, 우 이동
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        String check = "0";

        Deque<List<Integer>> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][M][N][M];

        q.offer(Arrays.asList(rRow, rCol, bRow, bCol, 0));
        visited[rRow][rCol][bRow][bCol] = true;

        while(!q.isEmpty()) {
            List<Integer> cur = q.poll();

            // 시도 횟수가 10회 초과한 경우 실패
            if(cur.get(4) > 10) {
                break;
            }

            // 빨간 구슬이 구멍에 도달한 경우 성공
            if(cur.get(0) == hRow && cur.get(1) == hCol) {
                check = "1";
                break;
            }

            int cRedx = cur.get(0), cRedy = cur.get(1);
            int cBluex = cur.get(2), cBluey = cur.get(3);

            // 1. 두 구슬 동시에 이동 가능한 곳까지 같이 이동
            // 2. 빨간 구슬 이동 가능한 곳까지 이동 (구멍포함)
            // 3. 파란 구슬 이동 가능한 곳까지 이동
                // 3-1. 파란 구슬 구멍 도달시 실패 => 다음 탐색
            // 4. 방문한 적이 없다면 큐에 추가
            for(int i = 0; i < 4 ; i++) {
                // 구슬 이동 가능한 경우 (둘다 벽만 아니면 됨)
                if(board[cRedx+dx[i]][cRedy+dy[i]] != '#' || board[cBluex+dx[i]][cBluey+dy[i]] != '#') {
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

                    // 2. 빨간 구슬 이동 가능한 곳까지 이동 (구멍포함)
                    if(board[nRedx+dx[i]][nRedy+dy[i]] != '#') {
                        char tmp = board[nBluex][nBluey];
                        board[nBluex][nBluey] = 'B';
                        while(board[nRedx+dx[i]][nRedy+dy[i]] == '.') {
                            nRedx += dx[i];
                            nRedy += dy[i];
                        }
                        board[nBluex][nBluey] = tmp; // 보드 복구

                        // 2-1. 빨간 구슬이 구멍에 들어감
                        if((nRedx+dx[i] == hRow) && (nRedy+dy[i] == hCol)) {
                            nRedx += dx[i];
                            nRedy += dy[i];
                        }
                    }

                    // 3. 파란 구슬 이동 가능한 곳까지 이동
                    if(board[nBluex+dx[i]][nBluey+dy[i]] != '#') {
                        char tmp = board[nRedx][nRedy];
                        board[nRedx][nRedy] = 'R';
                        while(board[nBluex+dx[i]][nBluey+dy[i]] == '.') {
                            nBluex += dx[i];
                            nBluey += dy[i];
                        }
                        board[nRedx][nRedy] = tmp;

                        // 3-1. 파란 구슬 구멍 도달시 실패 => 다음 탐색
                        if((nBluex+dx[i] == hRow) && (nBluey+dy[i] == hCol)) {
                            continue;
                        }
                    }

                    // 4. 방문한 적이 없다면 큐에 삽입
                    if (!visited[nRedx][nRedy][nBluex][nBluey]) {
                        q.offer(Arrays.asList(nRedx, nRedy, nBluex, nBluey, cur.get(4) + 1));
                        visited[nRedx][nRedy][nBluex][nBluey] = true;
                    }
                }
            }
        }
        bw.write(check);
        bw.flush();
    }
}

