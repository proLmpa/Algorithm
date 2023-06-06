package BackTracking;

import java.io.*;
import java.util.StringTokenizer;

public class bj_14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[] numbers;
    static boolean[] check;
    static char[] operands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        check = new boolean[N-1];
        operands = new char[N-1];
        int idx = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            for(int j = Integer.parseInt(st.nextToken()); j > 0; j--){
                switch(i) {
                    case 0: operands[idx++] = '+';
                            break;
                    case 1: operands[idx++] = '-';
                            break;
                    case 2: operands[idx++] = '*';
                            break;
                    case 3: operands[idx++] = '%';
                            break;
                }
            }
        }

        dfs(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int result) {
        if(depth == N-1){
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }

        for(int i = 0; i < N-1; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(depth+1, calculate(result, numbers[depth+1], operands[i]));

                check[i] = false;
            }
        }
    }

    static int calculate(int cur, int next, char operand){
        switch (operand) {
            case '+' : return cur + next;
            case '-' : return cur - next;
            case '*' : return cur * next;
            case '%' : return cur < 0 ? (Math.abs(cur) / next) * (-1) : cur / next;
            default: System.out.print("Not an operand");
                    return -1;
        }
    }
} // 368 ms

//
//import java.io.*;
//        import java.util.StringTokenizer;
//
//public class Main {
//    static int N;
//    static int[] number;
//    static boolean[] check;
//    static int[] ops = new int[4];
//    static StringTokenizer st;
//    static int MAX = Integer.MIN_VALUE;
//    static int MIN = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        number = new int[N];
//        check = new boolean[N];
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < N; i++)
//            number[i] = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < 4; i++)
//            ops[i] = Integer.parseInt(st.nextToken());
//
//        dfs(0, number[0]);
//        System.out.println(MAX);
//        System.out.println(MIN);
//    }
//
//    static void dfs(int depth, int result){
//        if(depth == N-1){
//            MAX = Math.max(result, MAX);
//            MIN = Math.min(result, MIN);
//            return;
//        }
//
//        if(ops[0] > 0){
//            ops[0]--;
//            dfs(depth+1, result + number[depth+1]);
//            ops[0]++;
//        } if(ops[1] > 0) {
//            ops[1]--;
//            dfs(depth + 1, result - number[depth + 1]);
//            ops[1]++;
//        } if(ops[2] > 0) {
//            ops[2]--;
//            dfs(depth+1, result * number[depth+1]);
//            ops[2]++;
//        } if(ops[3] > 0) {
//            ops[3]--;
//            dfs(depth+1, result/number[depth+1]);
//            ops[3]++;
//        }
//    }
//} 132 ms