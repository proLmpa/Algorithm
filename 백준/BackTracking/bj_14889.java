package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class bj_14889 {
    static int N;
    static boolean[] check;
    static int[][] S;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        check = new boolean[N];
        S = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(result);
    }

    static void dfs(int at, int depth) {
        if(depth == N/2){
            diff();
            return;
        }

        for(int i = at; i < N; i++){
            if(!check[i]){
                check[i] = true;
                dfs(i+1, depth+1);

                check[i] = false;
            }
        }
    }

    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = i+1; j < N; j++){
                if(check[i] && check[j]){
                    team_start += (S[i][j] + S[j][i]);
                }
                else if(!check[i] && !check[j]){
                    team_link += (S[i][j] + S[j][i]);
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if(val==0){
            System.out.print(val);
            System.exit(0);
        }

        result = Math.min(result, val);
    }
}
