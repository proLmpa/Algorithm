package GreedyAlgorithm;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 0;

        for(int i = 1; i <= N; i++) {
            dp[i] = -1;

            if(i >= 2 && dp[i-2] != -1) dp[i] = dp[i-2] + 1;
            if(i >= 5 && dp[i-5] != -1 && dp[i-2] != -1) dp[i] = Math.min(dp[i-5], dp[i-2]) + 1;
            else if(i >= 5 && dp[i-5] != -1) dp[i] = dp[i-5] + 1;
        }

        System.out.print(dp[N]);
    }
}
