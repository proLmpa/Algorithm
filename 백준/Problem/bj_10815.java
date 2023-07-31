package Problem;

public class bj_10815 {
    private static final int SIZE = 10000000;

    public static void main(String[] args) throws Exception {
        int N = read();
        boolean[] check = new boolean[SIZE*2+1];

        while(N-- > 0) {
            check[SIZE + read()] = true;
        }

        int M = read();

        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            int num = read();
            sb.append(check[SIZE + num] ? "1 " : "0 ");
        }

        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;
        if(isNegative) n = System.in.read() & 15;

        while((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return isNegative ? ~n + 1 : n ;
    }
} // 756 ms -> 404 ms
