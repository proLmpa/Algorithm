package MapSet;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1269 {

    private static final int range = 100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        boolean[] check = new boolean[range + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n1; i++) {
            int x = Integer.parseInt(st.nextToken());
            check[x] = true;
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(check[x]) cnt++;
        }

        System.out.print(arr1.length + arr2.length - 2 * cnt);
    }
}