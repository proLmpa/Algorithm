package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2630 {
    static int blue = 0;
    static int white = 0;
    static int[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);


        System.out.print(white + "\n" + blue);
    }

    static void divide(int x, int y, int size) {
        if(check(x, y, size)) {
            if(board[x][y] == 0) white++;
            else blue++;
            return;
        }

        size = size/2;
        divide(x, y, size);
        divide(x + size, y, size);
        divide(x, y + size, size);
        divide(x + size, y + size, size);
    }

    static boolean check(int x, int y, int size) {
        int color = board[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(board[i][j] != color) return false;
            }
        }
        return true;
    }
}