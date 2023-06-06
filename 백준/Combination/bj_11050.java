package Combination;

import java.io.*;
import java.util.*;

public class bj_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(factorial(n) / (factorial(k) * factorial(n-k)));
        System.out.print(sb);
    }

    static int factorial(int n){
        if(n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }
}

/*

public class Main {
    static int[][] da;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        da = new int[n+1][k+1];

        StringBuilder sb = new StringBuilder();
        sb.append(BC(n, k));
        System.out.print(sb);
    }

    static int BC(int n, int k){
        if(da[n][k] > 0) return da[n][k];

        if(n == k || k == 0) return da[n][k] = 1;

        return da[n][k] = BC(n-1, k) + BC(n-1, k-1);
    }
}

 */

// 풀이 출처: https://st-lab.tistory.com/159