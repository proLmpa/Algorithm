package Stack;

import java.io.*;
import java.util.Stack;

public class bj_1874 {
    static final String PLUS = "+\n", MINUS = "-\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int test_case = Integer.parseInt(br.readLine());
        int index = 0;
        int number;

        while(test_case-- > 0){
            number = Integer.parseInt(br.readLine());

            if(number > index){
                for(int i = index + 1; i <= number; i++){
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                index = number;
            }
            else if(stack.peek() != number){
                System.out.print("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.print(sb);
    }
}

// 풀이 출처: https://st-lab.tistory.com/182

/*
import java.io.*;
import java.util.Stack;

public class Main {
    static final String PLUS = "+\n", MINUS = "-\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int test_case = Integer.parseInt(br.readLine());
        boolean[] flags = new boolean[test_case + 1];
        int index = 1;
        int number;

        Loop : while(test_case-- > 0){
            number = Integer.parseInt(br.readLine());

            if(index < number){
                while(index < number){
                    if(flags[index++]) continue;
                    result += PLUS;
                }
                result += PLUS;
            }
            if(index >= number){
                while(index > number){
                    if(flags[index]) {
                        index--;
                        continue;
                    } else {
                        result = "NO";
                        break Loop;
                    }
                }
                if(index == number && !flags[index]){
                    flags[index] = true;
                    result += MINUS;
                }
            }
        }
        System.out.print(result);
    }
}
 */