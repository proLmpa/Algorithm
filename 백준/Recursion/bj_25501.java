package Recursion;

import java.io.*;

public class bj_25501 {
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        while(test_case-- > 0) {
            count = 0;
            String word = br.readLine();
            int check = isPalindrome(word);
            sb.append(check).append(' ').append(count).append('\n');
        }
        System.out.print(sb);
    }
    public static int recursion(String s, int l, int r) {
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
}
