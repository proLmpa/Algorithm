package DP;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1912 {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int idx = 0;
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];
        int max = arr[0];

        for(int i = 1; i < N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
            System.out.printf("%d %d\n", dp[i], max);
        }

        System.out.print(max);
    }

}
