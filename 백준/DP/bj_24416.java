package DP;

import java.io.*;

public class bj_24416 {
    static int[] f = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        sb.append(fib(N)).append(' ').append(N-2);
        System.out.print(sb);
    }

    static int fib(int n) {
        if(n == 1 || n == 2) return 1;
        else
            return ((fib(n-1) + fib(n-2)));
    }

    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
} // 460 ms -> 428 ms
