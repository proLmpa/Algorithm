package PriorityQueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0) {
                sb.append(pq.isEmpty() ? "0" : pq.poll()).append("\n");
            } else {
                pq.offer(k);
            }
        }

        System.out.print(sb);
    }
}