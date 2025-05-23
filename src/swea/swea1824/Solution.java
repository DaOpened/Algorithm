// swea 1824. 혁진이의 프로그램 검증
package swea.swea1824;

import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input_1824.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            String answer = "NO";
            int R = sc.nextInt();
            int C = sc.nextInt();

            char[][] command = new char[R][C];

            for(int r = 0; r < R; r++) {
                command[r] = sc.next().toCharArray();
            }

            // 0:left, 1:right, 2:up, 3:down
            int row = 0, col = 0, dir = 1, num = 0;
            int[] dx = {-1+C, 1, 0, 0};
            int[] dy = {0, 0, -1+R, +1};

            Set<List<Integer>> visited = new HashSet<>();
            Queue<List<Integer>> q = new LinkedList<>();
            q.offer(Arrays.asList(row, col, dir, num));

            while(!q.isEmpty()) {
                List<Integer> cur = q.poll();
                row = cur.get(0);
                col = cur.get(1);
                dir = cur.get(2);
                num = cur.get(3);
                char c = command[row][col];

                if(command[row][col] == '@') {
                    answer = "YES";
                    break;
                }

                if(visited.contains(cur)) {
                    continue;
                }

                visited.add(cur);

                // 입력이 0~9 인 경우
                if('0' <= c && c <= '9') {
                    num = c - '0';
                }
                // 이동방향 바꿈
                else if(c == '<') {
                    dir = 0;
                }
                else if(c == '>') {
                    dir = 1;
                }
                else if(c == '^') {
                    dir = 2;
                }
                else if(c == 'v') {
                    dir = 3;
                }
                else if(c == '_') {
                    if(num == 0) {
                        dir = 1;
                    }
                    else {
                        dir = 0;
                    }
                }
                else if(c == '|') {
                    if (num == 0) {
                        dir = 3;
                    }
                    else {
                        dir = 2;
                    }
                }
                else if(c == '+') num = (num+1)%16;
                else if(c == '-') num = (num+15)%16;
                else if(c == '?') {
                    for(int d = 0 ; d < 4; d++) {
                        int ncol = (col + dx[d]) % C;
                        int nrow = (row + dy[d]) % R;
                        List<Integer> next = Arrays.asList(nrow, ncol, d ,num);

                        if(!visited.contains(next))  {
                            q.offer(next);
                        }
                    }
                    continue;
                }

                col = (col + dx[dir]) % C;
                row = (row + dy[dir]) % R;
                q.offer(Arrays.asList(row, col, dir, num));
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}