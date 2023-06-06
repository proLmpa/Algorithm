package Numbers;

import java.io.*;

public class bj_17103 {
    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        sew();

        while(test_case-- > 0){
            int total = searchCase(Integer.parseInt(br.readLine()));
            sb.append(total).append('\n');
        }
        System.out.print(sb);
    }

    static void sew(){
        prime[0] = prime[1] = true;

        for(int i = 2; i <= 1000000; i++){
            if(!prime[i]) {
                for(int j = i + i; j <= 1000000; j += i) prime[j] = true;
            }
        }
    }

    static int searchCase(int num) {
        int total = 0;

        for(int i = 2; i <= num/2; i++){
            if(!prime[i] && !prime[num-i]) total++;
        }

        return total;
    }
}
