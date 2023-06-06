package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class bj_15650 {
    static int N;
    static int M;
    static boolean[] check;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        arr = new int[M];

        dfs(0, 0);
        System.out.print(sb);
    }

    static void dfs(int depth, int at) {
        if(depth == M) {
            int tmp = 0;
            for(int i : arr) {
                if(tmp > i) return;
                tmp = i;
            }

            for(int i : arr){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = at; i < N; i++){
            if(!check[i]) {
                check[i] = true;
                arr[depth] = i+1;
                dfs(depth+1, at+1);

                check[i] = false;
            }
        }
    }
}
