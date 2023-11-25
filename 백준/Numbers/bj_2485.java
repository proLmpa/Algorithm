package Numbers;

// 가로수 수: N (3 ~ 100,000)
// 가로수 위치: x ( ~ 1,000,000,000)

// 방정식? -> f(n) = a*n + b

// 방정식 사용 시 b는 무조건 첫 번째로 주어진 가로수 위치

// 이후 가로수 위치를 받을 때마다 자신 바로 이전의 가로수 위치와의 거리를 계산
// 가장 최소 차이를 보이는 거리를 증가 기준점 a로 삼고, a가 1이 될 때까지 1씩 빼기

import java.io.*;

public class bj_2485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        arr[0] = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(min > arr[i] - arr[i-1]) min = arr[i] - arr[i-1];
        }

        for(int i = min; i >= 1; i--) {

            boolean check = false;
            for(int j = 0; j < N; j++) {
                if((arr[j] - arr[0]) % i != 0) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                System.out.print((arr[N-1] - arr[0])/i - N + 1);
                break;
            }
        }
    }
}