package Deepen2;

import java.io.*;
import java.util.*;

public class bj_1037{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;
        int num = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < loop ; i++){
            num = Integer.parseInt(st.nextToken());
            if(num > max) max = num;
            if(num < min) min = num;
        }
        System.out.println(max*min);
    }
}// 너무 쉬운 문제였다...

/*
public class Deepen2.bj_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int[] divider = new int[test_case];
        int N;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < test_case; i++)
            divider[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(divider);
        StringBuilder sb = new StringBuilder();
        if(test_case%2 == 0){
            N = divider[0] * divider[divider.length - 1];
        } else {
            int tmp = divider[divider.length / 2];
            N = tmp * tmp;
        }
        sb.append(N);
        System.out.print(sb);
    }
}
*/