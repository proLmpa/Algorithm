package DP;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int result1 = dp[N-1][0];
        int result2 = dp[N-1][1];
        int result3 = dp[N-1][2];
        System.out.print(Math.min(Math.min(result1, result2), result3));
    }
} // 136 ms
