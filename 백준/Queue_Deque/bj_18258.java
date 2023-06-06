package Queue_Deque;

import java.io.*;
import java.util.*;

public class bj_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        Queue queue = new Queue(test_case);
        String line;

        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());

            if(st.countTokens() > 1){
                st.nextToken();
                queue.push(Integer.parseInt(st.nextToken()));
            } else {
                switch (st.nextToken()) {
                    case "pop" -> sb.append(queue.pop()).append('\n');
                    case "size" -> sb.append(queue.size()).append('\n');
                    case "empty" -> sb.append(queue.empty()).append('\n');
                    case "front" -> sb.append(queue.front()).append('\n');
                    case "back" -> sb.append(queue.back()).append('\n');
                }
            }

        }
        br.close();
        System.out.print(sb);
    }
}

class Queue {
    int front, back;
    int[] queue;

    Queue(int range) {
        front = 0;
        back = 0;
        queue = new int[range + 1];
    }

    void push(int number){
        queue[back++] = number;
    }

    int pop(){
        return front == back ? -1 : queue[front++];
    }

    int size() {
        return back - front;
    }

    int empty() {
        return front == back ? 1 : 0;
    }

    int front(){
        return front == back ? -1 : queue[front];
    }

    int back() {
        return front == back ? -1 : queue[back-1];
    }
}
// 1386 ms