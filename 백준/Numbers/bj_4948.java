package Numbers;

import java.io.*;

public class bj_4948 {
    static int num = 123456;
    static boolean[] prime = new boolean[2 * num + 1];

    static void makePrime() {
        prime[0] = prime[1] = true;

        for(int i = 2; i < prime.length; i++){
            if(!prime[i]){
                for(int j = i + i; j < prime.length; j += i)
                    prime[j] = true;
            }
        }
    }

    static int findPrime(int num){
        int total = 0;

        for(int i = num+1; i <= num * 2; i++){
            if(!prime[i]) total++;
        }

        return total;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makePrime();
        int num = Integer.parseInt(br.readLine());

        while(num != 0){
            int total = findPrime(num);
            sb.append(total).append('\n');

            num = Integer.parseInt(br.readLine());
        }

        System.out.print(sb);
    }
}

/*
import java.io.*;

public class Main{
    int range = 123456
    static boolean[] b = new boolean[2*range + 1];
    static int[] count_arr = new int[2*range + 1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        solution();
        count();

        int n = Integer.parseInt(br.readLine());
        while(n != 0){
            sb.append(count_arr[2*n] - count_arr[n]).append('\n');
        }

        System.out.print(sb);
    }

    public static void solution() {
        b[0] = b[1] = true;
        for(int i = 2; i < Math.sqrt(b.length); i++){
            if(b[i]) continue;
            for(int j = i*i; j < b.length; j+=i) b[j] = true;
        }
    }

    public static void count() {
        int count = 0;

        for(int i = 2; i < b.length; i++){
            if(!b[i]) count++;
            count_arr[i] = count;
        }
    }
}
 */
