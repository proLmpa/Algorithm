package Recursion;

import java.io.*;
import java.util.StringTokenizer;

public class bj_24060 {
    static int[] A;
    static int K;
    static int count = 0;
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < A.length; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(1, N);
        System.out.print(result);
    }

    public static void merge_sort(int p, int r){
        if(p < r) {
            int q = (p + r) / 2;    // q는 p, r의 중간 지점
            merge_sort(p, q);    // 전반부 정렬
            merge_sort(q+1, r);// 후반부 정렬
            merge(p, q, r);      // 병합
        }
    }

    // A[p ~ q]와 A[q+1 ~ r]을 병합하여 A[p ~ r]을 오름차순으로 정렬
    // A[p ~ q]와 A[q+1 ~ r]은 이미 오름차순으로 정렬되어 있다.
    public static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = 1;
        int[] tmp = new int[A.length];

        while(i <= q && j <= r) {
            if(A[i] <= A[j]) tmp[t++] = A[i++];
            else tmp[t++] = A[j++];
        }

        // 왼쪽 배열 부분이 남은 경우
        while(i <= q){
            tmp[t++] = A[i++];
        }
        // 오른쪽 배열 부분이 남은 경우
        while(j <= r){
            tmp[t++] = A[j++];
        }

        // 결과를 A에 저장
        i = p; t = 1;
        while(i <= r){
            A[i++] = tmp[t++];
            count++;
            if(count == K)
                result = tmp[t-1];

        }
    }
}
