package Queue_Deque;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class bj_1021 {
    static LinkedList<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for(int i = 1; i <= N; i++)
            queue.add(i);

        st = new StringTokenizer(br.readLine());
        while(M-- > 0) {
            int temp = Integer.parseInt(st.nextToken());
            int idx = search(temp);

            if(idx <= queue.size()/2) {
                while(idx-- > 0){
                    queue.add(queue.poll());
                    cnt++;
                }
            } else {
                while(queue.getFirst() != temp) {
                    queue.addFirst(queue.pollLast());
                    cnt++;
                }
            }

            queue.remove();
        }
        System.out.print(cnt);
    }

    static int search(int number) {
        for(int i = 0; i < queue.size(); i++){
            if(queue.get(i) == number) return i;
        }

        return -1;
    }
} // 132 ms

//import java.io.*;
//import java.util.*;
//
//public class Queue_Deque.bj_1021 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int cnt = 0;
//
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        for(int i = 1; i <= N; i++)
//            deque.add(i);
//
//        st = new StringTokenizer(br.readLine());
//        while(M-- > 0) {
//            int key = Integer.parseInt(st.nextToken());
//            int idx = 0;
//
//            for(Integer element: deque){
//                if(element == key) break;
//                idx++;
//            }
//
//            while(deque.getFirst() != key) {
//                if(deque.size() - idx < idx) {
//                    deque.addFirst(deque.pollLast());
//                    cnt++;
//                } else {
//                    deque.add(deque.poll());
//                    cnt++;
//                }
//            }
//
//            deque.poll();
//        }
//
//        System.out.print(cnt);
//    }
//} // 144 ms