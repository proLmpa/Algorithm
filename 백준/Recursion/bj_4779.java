package Recursion;

import java.io.*;
import java.util.Scanner;

public class bj_4779 {
    static final int SIZE = 12;
    static final String DASH = "-";
    static final String SPACE = " ";
    static String[] dash = new String[SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        factorial(SIZE);

        String str;
        while((str = br.readLine()) != null) {
            int N = Integer.parseInt(str);
            System.out.println(factorial(N));
        }
    }

    static String factorial(int N){
        if(N == 0) return dash[0] = DASH;
        if(dash[N] != null) return dash[N];

        double temp = Math.pow(3, N-1);
        return dash[N] = factorial(N-1) + SPACE.repeat((int)temp) + factorial(N-1);
    }
} // 240 ms
