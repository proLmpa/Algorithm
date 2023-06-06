package CumSum;

import java.io.*;
import java.util.StringTokenizer;

public class bj_2259 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int max = Integer.MIN_VALUE;
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N-K+1; i++){
            max = Math.max(max, arr[i+K-1] - arr[i-1]);
        }
        System.out.print(max);
    }
} // 276 ms

//public class Main {
//    public static void main(String[] args) throws Exception{
//        int N = read();
//        int K = read();
//        int[] arr = new int[N+1];
//        int max = Integer.MIN_VALUE;
//        arr[0] = 0;
//
//        for(int i = 1; i <= N; i++){
//            arr[i] = arr[i-1] + read();
//        }
//
//        for(int i = 1; i <= N-K+1; i++){
//            max = Math.max(max, arr[i+K-1] - arr[i-1]);
//        }
//        System.out.print(max);
//    }
//
//    private static int read() throws Exception {
//        int c, n = System.in.read() & 15;
//        boolean isNegative = n == 13;
//        if (isNegative) n = System.in.read() & 15;
//        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
//        return isNegative ? ~n + 1 : n;
//    }
//} // 144 ms