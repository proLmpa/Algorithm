package Queue_Deque;

import java.io.*;
import java.util.*;
import java.util.ArrayDeque;

public class bj_5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        Loop:
        while (test_case-- > 0) {
            String command = br.readLine();
            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            while (st.hasMoreTokens()) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(command, deque);
        }

        System.out.print(sb);
    }

    public static void AC(String command, ArrayDeque<Integer> deque) {
        boolean isRight = true;

        for(char cmd : command.toCharArray()) {
            if(cmd == 'R'){
                isRight = !isRight;
                continue;
            }

            // i) D 함수이면서 isRight이 true일 경우
            if(isRight) {
                if(deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                // 만약 반환된 원소가 없을 경우 error를 출력하도록 하고 함수 종료
                if(deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        // 모든 함수들이 정상적으로 작동했다면 덱의 남은 요소들을 출력문으로 만든다.
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append('[');

        if(deque.size() > 0) {
            if(isRight) {
                sb.append(deque.poll());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.poll());
                }
            }
            else {
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}