package Recursion;

import java.io.*;
import java.util.StringTokenizer;

public class bj_10870{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = factorial(n);
        System.out.print(sum);

    }

    public static int factorial(int n) {
        if(n <= 1) return n;
        return factorial(n - 1) + factorial(n - 2);
    }
}