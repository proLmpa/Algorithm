package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_9663 {

    private static int n;
    private static int count = 0;
    private static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 : N (1 ~ 15) -> N x N의 판에 N개의 퀸
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        nQueen(0);

        System.out.print(count);
    }

    private static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            // 혹은 대각선상에 놓여있는 경우
            if(board[col] == board[i] || Math.abs(col - i) == Math.abs(board[col] - board[i]))
                return false;
        }

        return true;
    }
}
