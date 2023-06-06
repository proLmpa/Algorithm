package DP;
import java.io.*;
import java.util.StringTokenizer;

public class bj_1932 {
    public static void main(String[] args) throws Exception{
        int N = read();
        int[][] dp = new int[N+1][N+1];

        dp[1][1] = read();

        for(int i = 2; i <= N; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + read();
            }
        }

        int result = 0;
        for(int i = 1; i <= N; i++){
            result = Math.max(result, dp[N][i]);
        }
        System.out.print(result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
} // 292 ms -> 152 ms

//public class Main {
//    public static void main(String[] args) throws Exception {
//        int n = read() + 1;
//        int[][] arr = new int[n][n];
//
//        for(int i = 1; i < n; i++){
//            for(int j = 1; j <= i; j++){
//                arr[i][j] = Math.max(arr[i-1][j-1], arr[i-1][j]) + read();
//            }
//        }
//
//        int max = 0;
//        for(int i = 1; i < n; i++)
//            max = Math.max(max, arr[n-1][i]);
//
//        System.out.print(max);
//    }
//
//    private static int read() throws Exception {
//        int c, n = System.in.read() & 15;
//        while((c = System.in.read()) > 32)
//            n = (n << 3) + (n << 1) + (c & 15);
//        return n;
//    }
//} // 158 ms