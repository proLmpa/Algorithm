package Deepen2;

import java.io.*;
import java.util.*;

public class bj_26069 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Boolean> member = new HashMap<>();
        int test_case = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());
            String m1 = st.nextToken();
            String m2 = st.nextToken();

            if(m1.equals("ChongChong") || m2.equals("ChongChong")){
                member.put(m1, false);
                member.put(m2, false);
            } else if(member.containsKey(m1))
                member.put(m2, false);
            else if(member.containsKey(m2))
                member.put(m1, false);

        }
        System.out.println(member.size());
    }
}

/*
public class Deepen2.bj_26069{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");

        int test_case = Integer.parseInt(br.readLine());
        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(!set.contains(a) && !set.contains(b)) continue;
            set.add(a);
            set.add(b);
        }

        System.out.println(set.size());
    }
}
*/