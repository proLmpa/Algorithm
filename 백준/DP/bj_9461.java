package DP;

import java.io.*;

public class bj_9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());

            sb.append(P(num)).append('\n');
        }

        System.out.print(sb);
    }

    static long P(int num) {
        if(num <= 3) return 1;

        long[] dp = new long[num+1];

        dp[1] = dp[2] = dp[3] = 1;
        for(int i = 4; i <= num; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }

        return dp[num];
    }
}
