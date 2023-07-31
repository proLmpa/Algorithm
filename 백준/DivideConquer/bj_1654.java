package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // ~ 10,000
        int N = Integer.parseInt(st.nextToken()); // ~ 1,000,000
        long[] arr = new long[K];

        long max = 0;
        for(int i = 0; i < K; i++){
            arr[i] = Long.parseLong(br.readLine()); // ~ 2^31 - 1
            max = Math.max(max, arr[i]);
        }

        System.out.println(binarySearch(arr, N, max));
    }

    private static long binarySearch(long[] arr, int N, long max) {
        long half;
        long min = 1;

        while(min <= max) {
            half = (min + max) / 2;
            long count = 0;

            for(long num : arr){
                count += num / half;
            }

            if(count < N) {
                max = half - 1;
            } else {
                min = half + 1;
            }
        }
        return (min+max) / 2;
    }
}