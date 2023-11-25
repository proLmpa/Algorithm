package BackTracking;
// 풀이 (40m) + 시도 (20m)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_6603 {
    private static int k;
    private static int[] arr;
    private static boolean[] check;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if(k == 0) break;
            check = new boolean[50];
            arr = new int[k];
            for(int i = 1; i <= k; i++) arr[i-1] = Integer.parseInt(st.nextToken());

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int depth, int index) {
        if(depth == 6) {
            for(int i = 0; i < k; i++){
                if(check[arr[i]]) sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = index; i < k; i++){
            check[arr[i]] = true;
            dfs(depth+1, i+1);
            check[arr[i]] = false;
        }
    }
} // Java 8: 96 ms (-> 88ms 까지 단축 가능)


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Main {
//    private static StringBuilder sb;
//    private static int k;
//    private static int[] arr;
//    private static boolean[] check;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        sb = new StringBuilder();
//
//        while(true) {
//            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            if(arr.length == 1) break;
//
//            k = arr[0];
//            check = new boolean[k];
//
//            for(int i = 1; i <= k - 5; i++){
//                check[i-1] = true;
//                String temp = arr[i] + " ";
//                bt(i+1, 1, temp);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }
//
//    private static void bt(int index, int depth, String sentence) {
//        if(depth == 6) {
//            sb.append(sentence + "\n");
//            return;
//        }
//
//        for(int i = index; i <= k ; i++) {
//            if(!check[i-1]) {
//                check[i-1] = true;
//                bt(i+1, depth + 1, sentence + arr[i] + " ");
//                check[i-1] = false;
//            }
//        }
//    }
//} // Java 8: 236 ms