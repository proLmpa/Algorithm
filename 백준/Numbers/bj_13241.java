package Numbers;

import java.io.*;
import java.util.*;

public class bj_13241 {
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    static long gcd(long a, long b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    static BufferedReader br;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String num1 = st.nextToken();
        String num2 = st.nextToken();

        StringBuilder sb = new StringBuilder();
        if(num1.length() >= 4){
            long a = Long.parseLong(num1);
            long b = Long.parseLong(num2);
            long gcd = gcd(a,b);
            sb.append(a * b / gcd).append('\n');
        } else {
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2);
            int gcd = gcd(a,b);
            sb.append(a * b / gcd).append('\n');
        }

        System.out.print(sb);
    }
}
