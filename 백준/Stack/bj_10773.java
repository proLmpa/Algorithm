package Stack;

import java.io.*;
import java.util.*;

public class bj_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        int total = 0;
        int tmp;
        Stack<Integer> stack = new Stack<>();

        while(test_case-- > 0){
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0) {
                stack.pop();
                continue;
            }
            stack.push(tmp);
        }


        for (Integer i : stack) {
            total += i;
        }
        sb.append(total);
        System.out.print(sb);
    }
} // 240 ms

/*
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int[] stack = new int[test_case+1];
        int position = 0;
        int sum = 0;
        int num;

        while(test_case-- > 0) {
            if((num = Integer.parseInt(br.readLine()))==0) sum -= stack[position--];
            else sum += (stack[++position] = num);
        }

        System.out.print(sum);
    }
}
 */ // 212 ms