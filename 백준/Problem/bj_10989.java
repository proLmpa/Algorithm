package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] check = new int[10001];

        while(N-- > 0) {
            check[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++){
            while(check[i] > 0) {
                check[i]--;
                sb.append(i + "\n");
            }
        }

        System.out.print(sb);
    }
} // 1768 ms
