package week03.problems.startTaxi;

import java.util.*;
import java.io.*;

public class Main {
    static int rowLen;
    static int customerLen;
    static int fuel;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rowLen = Integer.parseInt(st.nextToken());
        customerLen = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[rowLen][rowLen];

        for(int i = 0 ; i < rowLen ; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < rowLen ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

    }

}