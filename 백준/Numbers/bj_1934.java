package Numbers;

import java.io.*;
import java.util.*;

public class bj_1934 {
    /*
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    */

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int gcd = gcd(num1, num2);
            sb.append(num1 * num2 / gcd).append('\n');
        }
        System.out.print(sb);
    }
}