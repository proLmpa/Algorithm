package Queue_Deque;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class bj_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= number; i++){
            queue.add(i);
        }

        while (queue.size() != 1) {
            queue.remove();
            queue.add(queue.poll());
        }

        System.out.print(queue.poll());
    }

}
