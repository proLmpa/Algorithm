package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class bj_1920 {
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        // HashSet<Integer> given = (HashSet<Integer>) Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        HashSet<Integer> given = new HashSet<>();
        for(String s : br.readLine().split(" ")) {
            given.add(Integer.parseInt(s));
        }

        br.readLine();

        StringBuilder sb = new StringBuilder();
        for(String s : br.readLine().split(" ")) {
            sb.append(given.contains(Integer.parseInt(s)) ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }
} // 620 ms -> 588 ms