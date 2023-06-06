package Deepen2;

import java.io.*;
import java.util.*;

public class bj_25192 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // HashMap<String, Integer> member = new HashMap<>();
        HashSet<String> member = new HashSet<>();
        int test_case = Integer.parseInt(br.readLine());
        int total_emoji = 0;

        while(test_case-- > 0){
            String chat = br.readLine();
            if(chat.equals("ENTER"))
                member.clear();
            else {
                member.add(chat);
                total_emoji++;
            }
        }

        System.out.println(total_emoji);
    }
}
// 해쉬 맵보다 해쉬 셋이 더 적합함!