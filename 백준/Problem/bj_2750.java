package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[2001]; // -1000 ~ 1000 : 2001 -> 0 ~ 2000 (+1000)

        String temp;
        while(N-- > 0){
            check[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2001; i++){
            if(check[i]) sb.append(i-1000 + "\n");
        }

        System.out.print(sb);
    }
} // 164 ms -> Arrays.sort() : 136 ~ 140 ms
