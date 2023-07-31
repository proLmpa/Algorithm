package Queue_Deque;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class bj_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int test_case = Integer.parseInt(br.readLine());
        int tmp;

        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens() > 1) {
                switch (st.nextToken()) {
                    case "push_front" -> list.addFirst(Integer.parseInt(st.nextToken()));
                    case "push_back" -> list.addLast(Integer.parseInt(st.nextToken()));
                }
            } else {
                switch (st.nextToken()) {
                    case "pop_front" -> {
                        tmp = list.isEmpty() ? -1 : list.pollFirst();
                        sb.append(tmp).append('\n');
                    }
                    case "pop_back" -> {
                        tmp = list.isEmpty() ? -1 : list.pollLast();
                        sb.append(tmp).append('\n');
                    }
                    case "front" -> {
                        tmp = list.isEmpty() ? -1 : list.getFirst();
                        sb.append(tmp).append('\n');
                    }
                    case "back" -> {
                        tmp = list.isEmpty() ? -1 : list.getLast();
                        sb.append(tmp).append('\n');
                    }
                    case "size" -> {
                        tmp = list.isEmpty() ? 0 : list.size();
                        sb.append(tmp).append('\n');
                    }
                    case "empty" -> {
                        tmp = list.isEmpty() ? 1 : 0;
                        sb.append(tmp).append('\n');
                    }
                }
            }
        }
        System.out.print(sb);
    }
} // 212 ms --> 204 ms

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.ArrayDeque;
//        import java.util.Deque;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        int num;
//        StringBuilder sb = new StringBuilder();
//        while(N-- > 0) {
//            String[] input = br.readLine().split(" ");
//            switch(input[0]) {
//                case "push_front":
//                    deque.addFirst(Integer.parseInt(input[1]));
//                    break;
//                case "push_back":
//                    deque.addLast(Integer.parseInt(input[1]));
//                    break;
//                case "pop_front":
//                    num = deque.isEmpty() ? -1 : deque.removeFirst();
//                    sb.append(num + "\n");
//                    break;
//                case "pop_back":
//                    num = deque.isEmpty() ? -1 : deque.removeLast();
//                    sb.append(num + "\n");
//                    break;
//                case "size":
//                    sb.append(deque.size() + "\n");
//                    break;
//                case "empty":
//                    num = deque.isEmpty() ? 1 : 0;
//                    sb.append(num + "\n");
//                    break;
//                case "front":
//                    num = deque.isEmpty() ? -1 : deque.getFirst();
//                    sb.append(num + "\n");
//                    break;
//                case "back":
//                    num = deque.isEmpty() ? -1 : deque.getLast();
//                    sb.append(num + "\n");
//                    break;
//            }
//        }
//
//        System.out.print(sb);
//    }
//} // Java 8 : 164 ms (ArrayDeque<>)

//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.util.Deque;
//        import java.util.LinkedList;
//
//public class Main {
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        Deque<Integer> dq = new LinkedList<Integer>();
//
//        for(int i=0;i<N;i++) {
//            String com = br.readLine();
//            if(com.charAt(1) == 'i') {
//                sb.append(dq.size());
//            } else if(com.charAt(1) == 'm') {
//                sb.append((dq.isEmpty()?1:0));
//            } else if(com.charAt(1) == 'r') {
//                sb.append((dq.isEmpty()?-1:dq.getFirst()));
//            } else if(com.charAt(1) == 'a') {
//                sb.append((dq.isEmpty()?-1:dq.getLast()));
//            } else if(com.charAt(6) == 'r') {
//                dq.addFirst(Integer.parseInt(com.substring(11, com.length())));
//                continue;
//            } else if(com.charAt(6) == 'a') {
//                dq.addLast(Integer.parseInt(com.substring(10, com.length())));
//                continue;
//            } else if(com.charAt(6) == 'o') {
//                sb.append(dq.isEmpty()?-1:dq.removeFirst());
//            } else if(com.charAt(6) == 'c') {
//                sb.append(dq.isEmpty()?-1:dq.removeLast());
//            } else {
//                System.out.println("!!!!!!!");
//            }
//            sb.append('\n');
//        }
//        System.out.print(sb);
//    }
//} // Java 8 : 136 ms (charAt() + LinkedList<>)