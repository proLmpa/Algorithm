package Numbers;

import java.io.*;
import java.math.BigInteger;

public class bj_4134{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(test_case-- > 0){
            long num = Long.parseLong(br.readLine());
            BigInteger bigNumber = new BigInteger(String.valueOf(num));

            if(bigNumber.isProbablePrime(1))
                sb.append(num).append('\n');
            else
                sb.append(bigNumber.nextProbablePrime()).append('\n');
        }

        System.out.print(sb);
    }
}