package Problem;

import java.io.IOException;

public class bj_2751 {
    private static final int SIZE = 1000000;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int size = N;

        boolean[] arr = new boolean[SIZE*2 + 1];
        while(N-- > 0) {
            arr[readInt() + SIZE] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < SIZE*2 + 1 && N < size; i++){
            if(arr[i]) {
                sb.append(i-SIZE + "\n");
                N++;
            }
        }
        System.out.print(sb);
    }

    static int readInt() throws IOException {
        boolean isNegative = false;
        int sum = 0;
        while (true) {
            int input = System.in.read();
            if(input == '\n' || input == ' '){
                return isNegative ? -1 * sum : sum;
            } else if (input == '-') {
                isNegative = true;
            } else {
                sum = (sum * 10) + (input - '0');
            }
        }
    }
} // Arrays.sort() : 1648 ms -> 812 ms