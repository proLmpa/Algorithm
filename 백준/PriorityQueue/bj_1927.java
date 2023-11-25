package PriorityQueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Priority Queue 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) sb.append(pq.size() == 0 ? "0" : pq.poll()).append('\n');
            else pq.offer(tmp);
        }

        System.out.print(sb);
    }
}