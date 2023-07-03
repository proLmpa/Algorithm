package DivideConquer;

public class bj_2740 {
    private static int[][] A;
    private static int[][] B;

    public static void main(String[] args) throws Exception {
        A = readMatrix();
        B = readMatrix();

        mulMatrix();
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if(isNegative) n = System.in.read() & 15;
        while((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n +1 : n;
    }

    public static int[][] readMatrix() throws Exception {
        int N = read();
        int M = read();
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = read();
            }
        } // 행렬 값 받기

        return arr;
    }

    public static void mulMatrix() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B[0].length; j++) {
                int total = 0;

                for(int k = 0; k < B.length; k++){
                    total += A[i][k] * B[k][j];
                }
                sb.append(total + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}