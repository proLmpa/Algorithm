import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        while(n-- > 0) {
            int k = Integer.parseInt(br.readLine());

            if(k == 0) {
                if(list.isEmpty()) sb.append("0\n");
                else sb.append(list.removeFirst()).append("\n");
            }
            else {
                if(list.isEmpty()) list.add(k);
                else {
                    for(Integer num : list) {
                        if(k > num) {
                            list.add(list.indexOf(num), k);
                            break;
                        }
                    }
                }
            }
        }

        System.out.print(sb);
    }
}