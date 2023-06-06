package DP;

import java.io.*;

public class bj_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        if(N < 3){
            int answer = 0;
            for(int i = 0; i < N; i++) answer += arr[i];
            System.out.print(answer);
            return;
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        dp[2] = Math.max(dp[1], dp[2]);
        for(int i = 3; i < N; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        System.out.print(dp[N-1]);
    }
}
