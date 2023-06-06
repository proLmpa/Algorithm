package DP;

import java.io.*;
import java.util.StringTokenizer;

public class bj_9184 {
    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dynamic_w();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1) break;
            else if(a <= 0 || b <= 0 || c <= 0)
                System.out.printf("w(%d, %d, %d) = 1\n", a, b, c);
            else if (a > 20 || b > 20 || c > 20)
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, arr[20][20][20]);
            else
                System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, arr[a][b][c]);
        }
    }

    // 재귀 함수
    static int w(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if(a < b && b < c) return w(a, b, c-1) + w(a,b-1, c-1) - w(a, b-1, c);
        else return w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    // 동적 계획법
    static void dynamic_w() {
        arr[0][0][0] = 1;

        for(int i = 0; i <= 20; i++){
            for(int j = 0; j <= 20; j++){
                for(int k = 0; k <= 20; k++){
                    if(i == 0 || j == 0 || k == 0) arr[i][j][k] = 1;
                    else if(i < j && j < k)
                        arr[i][j][k] = arr[i][j][k-1] + arr[i][j-1][k-1] - arr[i][j-1][k];
                    else
                        arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1];
                }
            }
        } // 2288 ms
    }
}

// 2544 ms (오히려 더 커짐!)
//import java.io.*;
//        import java.util.StringTokenizer;
//
//public class Main {
//    private static final int SIZE = 20;
//    static int[][][] W = new int[SIZE+1][SIZE+1][SIZE+1];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        dynamic_w();
//
//        while(true) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            int ans;
//
//            if(a == -1 && b == -1 && c == -1) break;
//            if(a < 1 || b < 1 || c < 1) ans = 1;
//            else if(a > SIZE || b > SIZE || c > SIZE) ans = W[SIZE][SIZE][SIZE];
//            else ans = W[a][b][c];
//
//            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, ans);
//        }
//    }
//
//    static void dynamic_w() {
//        for(int i = 0; i <= SIZE; i++){
//            for(int j = 0; j <= SIZE; j++){
//                W[0][i][j] = W[i][0][j] = W[i][j][0] = 1;
//            }
//        }
//
//        for(int a = 1; a <= SIZE; a++){
//            for(int b = 1; b <= SIZE; b++){
//                for(int c = 1; c <= SIZE; c++){
//                    if(a < b && b < c)
//                        W[a][b][c] = W[a][b][c-1] + W[a][b-1][c-1] - W[a][b-1][c];
//                    else
//                        W[a][b][c] = W[a-1][b][c] + W[a-1][b-1][c] + W[a-1][b][c-1] - W[a-1][b-1][c-1];
//                }
//            }
//        }
//    }
//}