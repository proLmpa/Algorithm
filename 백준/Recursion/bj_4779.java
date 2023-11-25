import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_4779 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] kantour = new String[13];
        kantour[0] = "-";
        for(int i = 1; i <= 12; i++) {
            int dash = (int) Math.pow(3, i-1);
            kantour[i] = kantour[i - 1] + " ".repeat(dash) + kantour[i - 1];
        }

        String tmp;
        while((tmp = br.readLine()) != null) {
            if(tmp.equals("")) break;
            int x = Integer.parseInt(tmp);
            sb.append(kantour[x] + "\n");
        }

        System.out.print(sb);
    }
}