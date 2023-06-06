package DP;
import java.io.*;

public class bj_1463 {
    static int N;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new Integer[1000001];

        dp[0] = dp[1] = 0;

        for(int i = 2; i <= N; i++){
            dp[i] = find(i);
        }
        System.out.print(dp[N]);
    }

    static int find(int n){
        if(dp[n] == null){
            if(n%6==0) return Math.min(find(n-1), Math.min(find(n/2), find(n/3))) + 1;
            else if(n%3==0) return Math.min(find(n/3), find(n-1)) + 1;
            else if(n%2==0) return Math.min(find(n/2), find(n-1)) + 1;
            else return find(n-1) + 1;
        }

        return dp[n];
    }
}