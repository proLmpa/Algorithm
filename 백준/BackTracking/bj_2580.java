package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class bj_2580 {
    static int[][] sudoku = new int[9][9];
    static int total_cnt = 0;
    static boolean[] check = new boolean[9];
    static boolean[] checkX = new boolean[9];
    static boolean[] checkY = new boolean[9];
    static boolean[] check9 = new boolean[9];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int val = Integer.parseInt(st.nextToken());
                sudoku[i][j] = val;
                if (val != 0) total_cnt++;
            }
        }

        while(total_cnt < 81) {
            solveX(0, 0, 0, -1);
            solveY(0, 0, 0, -1);
            solve9(0,0,0);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void solveX(int depth, int x, int cnt, int idx) {
        // 0 ~ 8 번째 행의 모든 요소들을 비교했을 때 종료
        if (x == 9) return;

        // x 번째 행에서 0의 개수가 2개 이상일 때 혹은 x 번째 행을 방문한 적 있을 때,
        // 다음 x+1 번째 행으로 넘어가기
        if (cnt > 1 || checkX[x]) {
            check = new boolean[9];
            solveX(0, x + 1, 0, -1);
            return;
        }


        // x 번째 행의 마지막 요소까지 모두 확인했을 때
        if (depth == 9) {
            // 0의 개수가 1개 일 때
            if (cnt == 1) {
                for (int i = 0; i < 9; i++) {
                    if (!check[i]) {
                        sudoku[x][idx] = i + 1;
                        total_cnt++;
                    }
                }
            }

            checkX[x] = true;
            check = new boolean[9];
            solveX(0, x + 1, 0, -1);
            return;
        }

        if (sudoku[x][depth] != 0) {
            check[sudoku[x][depth] - 1] = true;
            solveX(depth + 1, x, cnt, idx);
        } else {
            solveX(depth + 1, x, cnt + 1, depth);
        }
    }

    static void solveY(int depth, int y, int cnt, int idx) {
        // 0 ~ 8 번째 열의 모든 요소들을 비교했을 때 종료
        if (y == 9) return;

        // y번째 열에서 0의 개수가 2개 이상일 때 혹은 y번째 열을 방문한 적 있을 때,
        // 다음 y+1 번째 열로 넘어가기
        if (cnt > 1 || checkY[y]) {
            check = new boolean[9];
            solveY(0, y + 1, 0, -1);
            return;
        }


        // y번째 열의 마지막 요소까지 모두 확인했을 때
        if (depth == 9) {
            // 0의 개수가 1개 일 때
            if (cnt == 1) {
                for (int i = 0; i < 9; i++) {
                    if (!check[i]) {
                        sudoku[idx][y] = i + 1;
                        total_cnt++;
                    }
                }
            }

            checkY[y] = true;
            check = new boolean[9];
            solveY(0, y + 1, 0, -1);
            return;
        }

        if (sudoku[depth][y] != 0) {
            check[sudoku[depth][y] - 1] = true;
            solveY(depth + 1, y, cnt, idx);
        } else {
            solveY(depth + 1, y, cnt + 1, depth);
        }
    }

    static void solve9(int depX, int depY, int cnt) {
        // 모든 3x3 행렬을 모두 탐색했을 때 종료
        if (depY == 3) return;

        // depX 가 일정 범위를 넘어설 때
        if(depX == 3){
            solve9(0, depY+1, 0);
            return;
        }

        // 해당 행렬에서 0의 개수가 2개 이상일 때 혹은 해당 행렬을 방문한 적 있을 때,
        // 다음 행렬로 넘어가기
        if (cnt > 1 || check9[3 * depX + depY]) {
            check = new boolean[9];
            solve9(depX + 1, depY, 0);
            return;
        }

        int idx = -1;
        int idy = -1;
        // 해당 행렬 탐색하기
        for (int i = 3 * depX; i < 3 * depX + 3; i++) {
            for (int j = 3 * depY; j < 3 * depY + 3; j++) {
                int val = sudoku[i][j];
                if (val != 0) check[val - 1] = true;
                else {
                    idx = i;
                    idy = j;
                    cnt++;
                    // 해당 행렬에서 0의 개수가 2개 이상일 때
                    // 다음 행렬로 넘기기
                    if (cnt > 1) {
                        solve9(depX, depY, cnt);
                        return;
                    }
                }
            }
        }

        check9[3 * depX + depY] = true;
        // 0의 개수가 1개 일 때
        if (cnt == 1) {
            for (int i = 0; i < 9; i++) {
                if (!check[i]) {
                    sudoku[idx][idy] = i + 1;
                    total_cnt++;
                }
            }
        }

        check = new boolean[9];
        if (depX < 3)
            solve9(depX + 1, depY, 0);
        else
            solve9(0, depY + 1, 0);
    }
}


//import java.io.*;
//        import java.util.StringTokenizer;
//
//public class Main {
//    static int[][] sudoku = new int[9][9];
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for(int i = 0; i < 9; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < 9; j++){
//                sudoku[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        sudoku(0, 0);
//    }
//
//    static void sudoku(int row, int col) {
//        // 해당 열이 다 채워졌을 경우 다음 행의 첫번째 열부터 시작
//        if(col == 9)
//            sudoku(row+1, 0);
//
//        // 행과 열이 모두 채워졌을 경우 출력 후 종료
//        if(row == 9) {
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0; i < 9; i++) {
//                for(int j = 0; j < 9; j++){
//                    sb.append(sudoku[i][j]).append(' ');
//                }
//                sb.append('\n');
//            }
//
//            System.out.print(sb);
//            // 출력 뒤 시스템 종료
//            System.exit(0);
//        }
//
//        // 만약 해당 위치의 값이 0이라면 1부터 9까지 중 가능한 수 탐색
//        if(sudoku[row][col] == 0) {
//            for(int i = 1; i <= 9; i++){
//                // i 값이 중복되지 않는지 검사
//                if(possibility(row, col, i)) {
//                    sudoku[row][col] = i;
//                    sudoku(row, col+1);
//                }
//            }
//
//            sudoku[row][col] = 0;
//            return;
//        }
//
//        sudoku(row, col+1);
//    }
//
//    static boolean possibility(int row, int col, int value) {
//        // 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
//        for(int i = 0; i < 9; i++){
//            if(sudoku[row][i] == value)
//                return false;
//        }
//
//        // 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
//        for(int i = 0; i < 9; i++){
//            if(sudoku[i][col] == value)
//                return false;
//        }
//
//        // 3*3 칸에 중복되는 원소가 있는지 검사
//        int set_row = (row/3) * 3;  // value가 속한 3x3 행의 첫 위치
//        int set_col = (col/3) * 3;  // value가 속한 3x3 열의 첫 위치
//
//        for(int i = set_row; i<set_row+3; i++){
//            for(int j = set_col; j<set_col+3;j++){
//                if(sudoku[i][j] == value)
//                    return false;
//            }
//        }
//
//        return true;
//    }
//}