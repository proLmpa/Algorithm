package Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_12789 {

    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 학생 수 : N (1 ~ 1000)
        int n = Integer.parseInt(br.readLine());
        // 이후 학생 번호 표 N개
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> line = new Stack<>();

        int tmp;
        int ticketNo = 1;
        String result = "Nice";

        while(st.hasMoreTokens()) {
            if(line.contains(ticketNo)) {
                if(line.lastElement() == ticketNo) {
                    line.pop();
                    ticketNo++;
                }
                else {
                    result = "Sad";
                    break;
                }
            } else {
                tmp = Integer.parseInt(st.nextToken());
                if(tmp == ticketNo) ticketNo++;
                else line.push(tmp);
            }
        }

        while(!line.isEmpty()) {
            if(line.lastElement() == ticketNo) {
                line.pop();
                ticketNo++;
            } else {
                result = "Sad";
                break;
            }
        }

        System.out.print(result);
    }
    // 1) Stack에 들어있는지 checker 점검
    // 2) checker에 기록됐고, Stack 마지막에 존재한다면 Nice
    // 3) checker에 기록됐지만, Stack 마지막에 없다면 Sad
    // 4) checker에 없다면, 다음 번호표가 나올 때까지 넘기기
}