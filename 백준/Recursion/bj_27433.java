package Recursion;

import java.io.*;

public class bj_27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine());

        System.out.print(factorial(number));
    }

    static long factorial(long number) {
        if(number <= 1) return 1;
        else return number * factorial(number - 1);
    }
}
