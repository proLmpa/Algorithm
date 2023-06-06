package DP;

import java.io.*;

// bottom-up 방식
public class bj_2579 {
    static int n;
    static Integer[] score;
    static int[] stair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        score = new Integer[n+1];
        stair = new int[n+1];

        for(int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());

        score[0] = stair[0];
        score[1] = stair[1];
        if(n >= 2)
            score[2] = stair[1] + stair[2];

        System.out.print(find(n));
    }

    static int find(int N) {
        if(score[N] == null){
            score[N] = Math.max(find(N-2), find(N-3) + stair[N-1]) + stair[N];
        }

        return score[N];
    }

    static void bottomUp(){
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for(int i = 4; i <= n; i++){
            score[i] = Math.max(score[i-3] + stair[i-1], score[i-2]) + stair[i];
        }
        System.out.print(score[n]);
    }
} // 120 ms