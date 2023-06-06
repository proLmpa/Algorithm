package Numbers;

import java.io.*;

public class bj_13909{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        sb.append((int)Math.sqrt(num)).append('\n');
        System.out.print(sb);
    }
}

/*
public class Numbers.bj_13909 {
    static int range = 2_100_000_000;
    static boolean[] window = new boolean[range + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int total = opening(num);

        sb.append(total).append('\n');
        System.out.print(sb);
    }

    static int opening(int num) {
        int total = 0;

        for(int i = 1; i <= num; i++){
            for(int j = i; j <= num; j += i){
                window[j] = !window[j];
            }
            if(window[i]) total++;
        }

        return total;
    }
}
*/