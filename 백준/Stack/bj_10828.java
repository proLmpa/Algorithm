package Stack;

import java.io.*;
import java.util.*;

class bjStack{
    int[] stack;
    int size;


    bjStack(int lines) {
        stack = new int[lines+1];
        size = 0;
    }

    void push(int num) {
        size++;
        stack[size] = num;
    }

    int pop(){
        if(size == 0) return -1;

        int num = stack[size];
        size--;
        return num;
    }

    int size() {
        return size;
    }

    int empty() {
        if(size == 0) return 1;
        return 0;
    }

    int top(){
        if(size==0) return -1;

        return stack[size];
    }
}

public class bj_10828 {
    static final char LF = '\n';

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());
        bjStack stack = new bjStack(test_case);
        String command;
        int parameter;

        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());

            if(st.countTokens() > 1){
                st.nextToken();
                parameter = Integer.parseInt(st.nextToken());

                stack.push(parameter);
            } else {
                command = st.nextToken();

                switch (command) {
                    case "pop" -> sb.append(stack.pop()).append(LF);
                    case "top" -> sb.append(stack.top()).append(LF);
                    case "empty" -> sb.append(stack.empty()).append(LF);
                    default -> sb.append(stack.size()).append(LF);
                }
            }
        }

        System.out.print(sb);
    }
}
