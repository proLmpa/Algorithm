package DivideConquer;

import java.io.IOException;

public class bj_1780 {
    private static int[][] paper;

    private static int[] values;

    public static void main(String[] args) throws IOException{
        int N = read();
        paper = new int[N][N];
        values = new int[3];
        values[0] = 0;
        values[1] = 0;
        values[2] = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                paper[i][j] = read();
            }
        }

        divide(0,0,N);
        System.out.println(values[2]);
        System.out.println(values[0]);
        System.out.println(values[1]);
    }

    public static void divide(int x, int y, int size) {
        if(check(x, y, size)) {
            int value = paper[x][y];
            values[value]++;
        } else {
            int newSize = size/3;
            divide(x, y, newSize);
            divide(x + newSize, y, newSize);
            divide(x + newSize*2, y, newSize);
            divide(x, y+newSize, newSize);
            divide(x + newSize, y+newSize, newSize);
            divide(x + newSize*2, y+newSize, newSize);
            divide(x, y+newSize*2, newSize);
            divide(x + newSize, y+newSize*2, newSize);
            divide(x + newSize*2, y+newSize*2, newSize);
        }
    }

    public static boolean check(int x, int y, int size) {
        int value = paper[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != value) return false;
            }
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read();
        boolean isMinus = false;
        if (n == 45) {
            isMinus = true;
            n = System.in.read() & 15;
        } else {
            n = n & 15;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isMinus ? 2 : n;
    }
}
// HashMap -> int[]
// 1456 ms -> 904 ms
