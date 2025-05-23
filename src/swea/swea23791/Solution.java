// swea 23791. 지명 선수
package swea.swea23791;

import java.util.*;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input_23791.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];

            for(int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            for(int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
            }

            Map<Integer, String> team = new HashMap<Integer, String>();
            int idxA = 0, idxB = 0;
            for(int i = 0; i < N; i++) {
                // A팀 결정
                if(i % 2 == 0) {
                    for (int j = idxA; j < N; j++) {
                        if (!team.containsKey(A[j])) {
                            team.put(A[j], "A");
                            idxA = j+1;
                            break;
                        }
                    }
                }
                // B팀 결정
                else {
                    for (int j = idxB; j < N; j++) {
                        if (!team.containsKey(B[j])) {
                            team.put(B[j], "B");
                            idxB = j+1;
                            break;
                        }
                    }
                }
            }

            List<Map.Entry<Integer, String>> list = new ArrayList<>(team.entrySet());
            list.sort(Comparator.comparing(Map.Entry<Integer, String>::getKey));
            for(Map.Entry<Integer, String> entry : list) {
                System.out.printf(entry.getValue());
            }
            System.out.println();
        }
    }
}