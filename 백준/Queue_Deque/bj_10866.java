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
