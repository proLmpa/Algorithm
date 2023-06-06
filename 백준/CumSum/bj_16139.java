package CumSum;

import java.io.*;
import java.util.StringTokenizer;

public class bj_16139 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[][] chk = new int[S.length()][26];

        chk[0][S.charAt(0) - 'a'] = 1;
        for(int i = 1; i < S.length(); i++){
            for(int j = 0; j < 26; j++){
                chk[i][j] = chk[i-1][j];
            }
            chk[i][S.charAt(i) - 'a']++;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(r == 0) sb.append(0 + "\n");
            else
                sb.append(l == 0 ? chk[r][a - 'a'] : chk[r][a - 'a'] - chk[l-1][a - 'a']).append("\n");
        }
        System.out.print(sb);
    }
}