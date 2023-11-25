package DivideConquer;

import java.io.IOException;
import java.util.Arrays;

public class bj_2805 {
    private static long[] trees;
    private static int m;

    public static void main(String[] args) throws IOException {
        int n = readInt(); // 나무의 수
        m = readInt(); // 가져갈 나무 길이
        trees = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = readInt();
            max = Math.max(max, trees[i]);
        }

        System.out.println(dc(0, max));
    }

    private static long dc(long left, long right) {
        while(left <= right) {
            long mid = (left + right) / 2;
            long meters = Arrays.stream(trees).map(tree -> tree >= mid ? tree - mid : 0).sum();

            if(meters < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (left + right) / 2;
    } // Java 8: 656 ms -> readInt : 476 ms -> max 세기 제거 시 : 560 ms

    static int readInt() throws IOException {
        int n = 0;
        boolean isNegative = false;
        while (true) {
            int input = System.in.read();
            if (input<=32)
                return isNegative ? n * -1 : n;
            else if(input=='-')
                isNegative = true;
            else
                n = (n<<3) + (n<<1) + (input&15);
        }
    }

//    private static long binarySearch(long left, long right) {
//        long mid = (left + right) / 2;
//        long meters = Arrays.stream(trees).map(tree -> tree >= mid ? tree - mid : 0).sum();
//
//        if(meters < m) {
//            return binarySearch(left, mid-1);
//        } else if(meters > m){
//            return binarySearch(mid+1, right);
//        } else
//            return mid;
//    } // 실패
}