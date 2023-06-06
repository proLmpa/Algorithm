package Queue_Deque;

import java.io.*;
import java.util.*;

public class bj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N + 1];
        int test_case = N;
        int temp = 0;
        int idx;

        sb.append('<');
        while (test_case-- > 0){
            idx = 0;
            while(idx < K){
                temp += 1;
                if(temp > N) temp = 1;
                if(check[temp]) continue;
                idx++;
            }

            if(test_case == 0)
                sb.append(temp).append('>');
            else
                sb.append(temp).append(", ");
            check[temp] = true;
        }

        System.out.print(sb);
    }
} // 144 ms --> 148 ms

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_Deque.bj_11866 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = stringToInt(st.nextToken());
        int k = stringToInt(st.nextToken());
        int idx = 0;

        //list값 셋팅
        for (int i=0; i<n; i++) {
            list.add(i+1);
        }

        sb.append("<");

        while(n > 1) {
            idx = (idx + (k - 1)) % n; //꺼내와야할 값의 index를 구한다.
            sb.append(list.remove(idx)).append(", ");
            n--;
        }
        sb.append(list.remove()).append(">");
        System.out.println(sb);
    }

    static int stringToInt(String param) {
        return Integer.parseInt(param);
    }
} // 128 ms
*/