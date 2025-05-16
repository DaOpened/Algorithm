package week03.maze.examples.bufferInput;

import java.io.*;
import java.util.StringTokenizer;

// 빠른 입력을 위한 buffered
public class Solution {
    // 메인 함수에 예외 발생 처리해야!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 처음 들어온 숫자 저장
            int y = Integer.parseInt(st.nextToken()); // 두번째 들어온 숫자 저장
            // String만 출력 가능
            bw.write(String.valueOf(x)+" "); // 첫번째 int값 String으로 변환하여 출력
            bw.write(String.valueOf(y)+"\n");
        }
        bw.flush(); // 이걸 써야 화면에 출력됨

    }
}
