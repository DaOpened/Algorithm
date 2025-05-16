package week03.maze.examples.bufferInput.baekjoon4344;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] students = new int[n];
            int sum = 0;

            for(int j = 0 ; j < n ; j++) {
                students[j] = Integer.parseInt(st.nextToken());
                sum += students[j];
            }

            int cnt = 0;
            for(int student: students) {
                if(student*n > sum)
                    cnt++;
            }

            double avg = (double) cnt / n * 100;
            bw.write(String.format("%.3f", avg)+"%\n");
        }
        bw.flush();
    }
}