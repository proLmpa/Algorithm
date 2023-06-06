package Combination;

import java.io.*;
import java.util.*;

public class bj_1010 {
    static int[][] da = new int[30][30];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(bridging(M, N)).append('\n');
        }

        System.out.print(sb);
    }

    static int bridging(int N, int M){
        if(da[N][M] > 0) return da[N][M];

        if(N == M || M == 0) return da[N][M] = 1;

        return da[N][M] = bridging(N-1, M) + bridging(N-1, M-1);
    }
}
