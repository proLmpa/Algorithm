package CumSum;

import java.io.*;
import java.util.StringTokenizer;

public class bj_11659 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        arr[0] = 0;
        dp[0] = 0;


        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[b] - dp[a-1] + "\n");
        }
        System.out.print(sb);
    }
} // 724 ms -> 672 ms

//class Main {
//    public static void main(String[] args) throws Exception {
//        int N = nextInt();
//        int M = nextInt();
//        int[] dp = new int[N+1];
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 1; i <= N; i++) dp[i] = dp[i-1] + nextInt();
//
//        while(M-- > 0){
//            int i = nextInt();
//            int j = nextInt();
//            sb.append(dp[j] - dp[i-1] + "\n");
//        }
//        System.out.print(sb);
//    }
//
//    static final int BUFFER_SIZE = 1 << 13;
//    static byte[] buffer = new byte[BUFFER_SIZE];
//    static int bufferIndex, bufferLength;
//
//    static int nextInt() throws Exception {
//        int n = 0;
//        byte c;
//
//        while((c = read()) <= 32);
//        do n = (n << 3) + (n << 1) + (c & 15);
//        while(isNumber(c = read()));
//        return n;
//    }
//
//    static boolean isNumber(byte c) {
//        return 47 < c && c < 58;
//    }
//
//    static byte read() throws Exception {
//        if(bufferIndex == bufferLength) {
//            bufferLength = System.in.read(buffer, bufferIndex = 0, BUFFER_SIZE);
//            if(bufferLength == -1) buffer[0] = -1;
//        }
//        return buffer[bufferIndex++];
//    }
//} // 364 ms