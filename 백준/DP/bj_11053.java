package DP;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11053 {
    private static int[] arr; // 원 배열
    private static int[] lis; // LIS 길이 저장
    private static int[] V;    // 이전 인덱스 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        lis = new int[n];
        V = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = dp();
        System.out.print(lis[result]);
    }

    public static int dp() {
        // 최대 lis 길이 값
        int max_lis = 0;

        // 최대 길이를 만족시키는 부분 수열의 마지막 인덱스, 초기는 0
        int last = 0;

        // lis[0]은 정했으니 그 이후부터 채우기
        for(int i = 0; i < arr.length; i++) {
            lis[i] = 1;    // 기본 1로 초기화
            V[i] = -1;    // 기본 -1로 초기화

            for(int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i] && lis[j] >= lis[i]) {
                    lis[i] = lis[j] + 1;
                    V[i] = j; // 이전 인덱스 저장
                }
                if(max_lis < lis[i]) {
                    max_lis = lis[i];
                    last = i;
                }
            }
        }
        return last;
    }
}