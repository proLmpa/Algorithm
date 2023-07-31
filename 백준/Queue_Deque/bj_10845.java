package Queue_Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        StringBuilder sb = new StringBuilder();
        while(N-- > 0) {
            String[] temp = br.readLine().split(" ");
            switch(temp[0]) {
                case "push":
                    queue.push(Integer.parseInt(temp[1]));
                    break;
                case "pop":
                    sb.append(queue.pop() + "\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() + "\n");
                    break;
                case "front":
                    sb.append(queue.front() + "\n");
                    break;
                case "back":
                    sb.append(queue.back() + "\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    private static class Queue {
        private List<Integer> arr;

        public Queue(int size) {
            arr = new ArrayList<>(size);
        }

        public void push(int x) {
            arr.add(x);
        }

        public int pop() {
            return arr.isEmpty() ? -1 : arr.remove(0);
        }

        public int size() {
            return arr.size();
        }

        public int isEmpty() {
            return arr.isEmpty() ? 1 : 0;
        }

        public int front() {
            return arr.isEmpty() ? -1 : arr.get(0);
        }

        public int back() {
            return arr.isEmpty() ? -1 : arr.get(arr.size() - 1);
        }
    }
} // Java 8: 156 ms

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayDeque;
//        import java.util.Queue;
//
//public class Main {
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        ArrayDeque<String> deque = new ArrayDeque<>();
//        StringBuilder sb = new StringBuilder();
//        while (n-- > 0) {
//            String command = br.readLine();
//            switch (command) {
//                case "pop":
//                    if (deque.isEmpty()) sb.append(-1).append("\n");
//                    else sb.append(deque.pollFirst()).append("\n");
//                    break;
//                case "size":
//                    sb.append(deque.size()).append("\n");
//                    break;
//                case "empty":
//                    if (deque.isEmpty()) sb.append(1).append("\n");
//                    else sb.append(0).append("\n");
//                    break;
//                case "front":
//                    if (deque.isEmpty()) sb.append(-1).append("\n");
//                    else sb.append(deque.peekFirst()).append("\n");
//                    break;
//                case "back":
//                    if (deque.isEmpty()) sb.append(-1).append("\n");
//                    else sb.append(deque.peekLast()).append("\n");
//                    break;
//                default:
//                    deque.offer(command.substring(5));
//                    break;
//            }
//        }
//        System.out.print(sb);
//    }
//} // Java 8: 108 ms

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class Main {
//
//    private static mQueue queue;
//    private final static int NON = 100_001;
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int N = Integer.parseInt(br.readLine());
//        queue = new mQueue();
//        for (int i = 0; i < N; i++) {
//            int result = run(br.readLine());
//
//            if (result != NON) {
//                sb.append(result).append('\n');
//            }
//        }
//
//        System.out.println(sb);
//    }
//
//    private static int run(String cmd) {
//
//        switch (cmd.charAt(0)) {
//            case 'p':
//                if (cmd.charAt(1) == 'u') {
//                    int n = Integer.parseInt(cmd.substring(5));
//                    queue.push(n);
//                    return NON;
//                } else
//                    return queue.pop();
//            case 's':
//                return queue.size();
//            case 'e':
//                return queue.empty();
//            case 'f':
//                return queue.front();
//            case 'b':
//                return queue.back();
//        }
//        return 0;
//    }
//
//}
//
//class mQueue {
//    int[] arr = new int[10_000];
//    int front = 0;
//    int back = 0;
//
//
//    public void push(int n) {
//        arr[back++] = n;
//    }
//
//    public int pop() {
//        if(isEmpty()) return -1;
//        int n = arr[front];
//        front++;
//        return n;
//    }
//
//    public int size() {
//        return back - front;
//    }
//
//    private boolean isEmpty() {
//        if(front == back) return true;
//        else return false;
//    }
//
//    public int empty() {
//        if (isEmpty()) return 1;
//        else return 0;
//    }
//
//    public int front() {
//        if (isEmpty()) return -1;
//        else return arr[front];
//    }
//
//    public int back() {
//        if (isEmpty()) return -1;
//        else return arr[back-1];
//    }
//} // Java 8 : 124 ms