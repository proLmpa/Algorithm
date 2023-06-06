package Stack;

import java.io.*;
import java.util.Stack;

public class bj_4949 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp;

        while(true){
            temp = br.readLine();
            if(temp.charAt(0) == '.') break;

            sb.append(solve(temp)).append('\n');
        }
        br.close();
        System.out.print(sb);
    }

    static String solve(String sentence){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < sentence.length(); i++){
            char letter = sentence.charAt(i);

            if(letter == '(' || letter == '[') stack.push(letter);
            else if (letter == ')'){
                if(stack.empty() || stack.pop() != '(') return "no";
            }
            else if(letter == ']'){
                if(stack.empty() || stack.pop() != '[') return "no";
            }
        }

        if(stack.empty()) return "yes";
        else return "no";
    }
}
