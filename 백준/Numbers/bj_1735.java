package Numbers;

import java.io.*;
import java.util.*;

public class bj_1735 {
    static int gcd(int a, int b){
        if (b == 0) return a;
        else return gcd(b, a%b);
    }

    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int bunja1 = Integer.parseInt(st.nextToken());
        int bunmo1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int bunja2 = Integer.parseInt(st.nextToken());
        int bunmo2 = Integer.parseInt(st.nextToken());

        int new_bunmo = bunmo1 * bunmo2 / gcd(bunmo1, bunmo2);
        int new_bunja = bunja1 * (new_bunmo / bunmo1) + bunja2 * (new_bunmo / bunmo2);

        StringBuilder sb = new StringBuilder();
        int gcd = gcd(new_bunja, new_bunmo);
        if(gcd == 1){
            sb.append(Integer.toString(new_bunja)).append(" ").append(Integer.toString(new_bunmo));
        } else {
            sb.append(Integer.toString(new_bunja/gcd)).append(" ").append(Integer.toString(new_bunmo/gcd));
        }

        System.out.print(sb);
    }
}