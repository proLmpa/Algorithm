package DP;

import java.io.*;

public class bj_1904 {
    static int[] arr = new int[1_000_001];
    static final int div = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= N; i++)
            arr[i] = (arr[i-1] + arr[i-2]) %div;

        System.out.print(arr[N]);
    }

} // 136 ms
