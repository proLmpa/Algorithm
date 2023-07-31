package CumSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_1018 {
    public static int f(int n){
        if(n<32) return n;
        return 64-n;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] board = new int[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                if((i+j)%2 == 0)
                    board[i][j] = (s.charAt(j)=='W')? 0 : 1;
                else
                    board[i][j] = (s.charAt(j)=='B')? 0 : 1;
            }
        }
        int[][] cumSum = new int[n][m-7];
        for(int i=0;i<n;i++){
            for(int j=0;j<8;j++)
                cumSum[i][0]+=board[i][j];
            for(int j=1;j<m-7;j++)
                cumSum[i][j]=cumSum[i][j-1]+board[i][j+7]-board[i][j-1];
        }

        int min = 32;
        int change;
        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                change = 0;
                for(int k=0;k<8;k++)
                    change+=cumSum[i+k][j];
                if(min>f(change))
                    min = f(change);
            }
        }
        System.out.println(min);
    }
} // Java 8: 76 ms

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Main {
//    private static String[][] board;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
//        board = new String[N][M];
//
//        for(int i = 0; i<N; i++) {
//            input = br.readLine().split("");
//            board[i] = Arrays.copyOf(input, input.length);
//        }
//
//        int min = Integer.MAX_VALUE;
//        for(int i = 0; i <= N-8; i++){
//            for(int j = 0; j <= M-8; j++) {
//                min = Math.min(min, checkBoard(i, j));
//            }
//            if(min == 0) break;
//        }
//
//        System.out.println(min);
//    }
//
//    private static int checkBoard(int row, int col) {
//        int result1 = 0;
//        int result2 = 0;
//        String standard = board[row][col];
//
//        for(int i = row; i < row + 8; i++) {
//            for(int j = col; j < col + 8; j++) {
//                int k = (i - row) + (j - col);
//
//                if(k%2 == 0) {
//                    if(!standard.equals(board[i][j])) result1++;
//                    else result2++;
//                } else {
//                    if(standard.equals(board[i][j])) result1++;
//                    else result2++;
//                }
//            }
//        }
//
//        return Math.min(result1, result2);
//    }
//} // Java 8: 112 ms
