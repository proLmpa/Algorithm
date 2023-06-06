package Stack;

import java.io.*;

public class bj_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        String temp;
        int total;

        while(test_case-- > 0){
            temp = br.readLine();
            total = 0;

            for(int i = 0; i < temp.length(); i++){
                if(temp.charAt(i) == '(') total++;
                else if(temp.charAt(i) == ')') total--;

                if(total < 0) break;
            }
            if(total == 0) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        br.close();
        System.out.print(sb);
    }
}
