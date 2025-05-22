// swea 1249번: [S/W 문제해결 응용] 4일차 - 보급로
// java8 로 작성됨
package swea.swea1249;

import java.io.FileInputStream;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        // System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();
            sc.nextLine(); // 개행 제거

            // map을 int[][]로 변환하여 저장
            int[][] map = new int[size][size];
            for(int i = 0; i < size; i++) {
                String line = sc.nextLine();
                for(int j = 0; j < size; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }

            Queue<List<Integer>> q = new LinkedList<>();
            int[][] distance = new int[size][size];
            Map<List<Integer>, Integer> dist = new HashMap<>();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            q.offer(new LinkedList<>(Arrays.asList(0, 0)));
            dist.put(new ArrayList<>(Arrays.asList(0, 0)), 0);

            while(!q.isEmpty()) {
                List<Integer> cur = q.poll();
                int curx = cur.get(0);
                int cury = cur.get(1);
                int curd = dist.get(cur);

                for(int i = 0; i < 4; i++) {
                    int nx = curx + dx[i];
                    int ny = cury + dy[i];

                    if(0<=nx && nx<size && 0<=ny && ny<size) {
                        int nd = map[nx][ny] + curd;
                        List<Integer> next = new ArrayList<>(Arrays.asList(nx, ny));
                        if(!dist.containsKey(next)) {
                            dist.put(next, nd);
                            q.offer(next);
                        } else {
                            if(dist.get(next) > nd) {
                                dist.put(next, nd);
                                q.offer(next);
                            }
                        }
                    }
                }
            }
            int mindis = dist.get(new ArrayList<>(Arrays.asList(size-1, size-1)));

            System.out.println("#"+test_case + " " + mindis);
        }
    }
}
