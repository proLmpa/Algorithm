package DivideConquer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10830 {
    private static int N;
    private static int[][] A;

    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long exponent = Long.parseLong(st.nextToken());
        A = readMatrix();

        int[][] answer = dq(exponent);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] readMatrix() throws IOException {
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        } // 행렬 값 받기

        return arr;
    }

    public static int[][] dq(long exponent) {
        if(exponent == 1) return A; // A%C

        int[][] arr = dq(exponent/2);

        if(exponent%2 == 0) return mulMatrix(arr, arr);
        else return mulMatrix(mulMatrix(arr, arr), A);
    }

    public static int[][] mulMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++){
                    arr[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                arr[i][j] %= 1000;
            }
        }

        return arr;
    }
} // 144 ms