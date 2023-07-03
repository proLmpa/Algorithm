package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_1992 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = temp.charAt(j) - '0';
            }
        }

        quadTree(0,0, N);
        if(sb.length() == 1) {
            System.out.print("(" + sb.toString() + ")");
            return;
        }
        System.out.print(sb);
    }

    static void quadTree(int x, int y, int size) {

        if(check(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append('(');

        int newSize = size/2;
        quadTree(x, y, newSize);
        quadTree(x, y+newSize, newSize);
        quadTree(x+newSize, y, newSize);
        quadTree(x+newSize, y+newSize, newSize);

        sb.append(')');
    }

    static boolean check(int x, int y, int size) {
        int std = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != std) return false;
            }
        }
        return true;
    }
}