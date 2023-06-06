package Queue_Deque;

import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class bj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        while(test_case-- > 0){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();   // Queue로 활용할 연결리스트
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                // {초기 위치, 중요도}
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;
            while(!q.isEmpty()){
                int[] front = q.poll(); // 첫 원소
                boolean isMax = true;   // front 원소가 가장 큰 원소인지

                for(int i = 0; i < q.size(); i++){
                    if(front[1] < q.get(i)[1]) {
                        q.offer(front);
                        for(int j = 0; j < i; j++){
                            q.offer(q.poll());
                        }

                        // front 원소가 가장 큰 원소가 아니었으므로 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                if(!isMax) continue;

                cnt++;
                if(front[0] == M) break;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
} // 156 ms
// 풀이 출처: https://st-lab.tistory.com/201

//import java.io.*;
//import java.util.*;
//import java.util.LinkedList;
//
//public class Queue_Deque.bj_1966 {
//    static LinkedList<Integer> list = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//        int test_case = Integer.parseInt(br.readLine());
//
//        while(test_case-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//            int cnt = 0;
//
//            st = new StringTokenizer(br.readLine());
//                for(int i = 0; i < N; i++)
//                    list.add(Integer.parseInt(st.nextToken()));
//
//            while(true) {
//                if(biggest()){
//                    list.poll();
//                    cnt++;
//                    if(M == 0) break;
//                    M--;
//                } else {
//                    list.add(list.poll());
//                    if(--M < 0) M = list.size() - 1;
//                }
//            }
//
//            sb.append(cnt).append('\n');
//            list.clear();
//        }
//        System.out.print(sb);
//    }
//
//    static boolean biggest() {
//        for(int i = 1; i < list.size(); i++){
//            if(list.get(0) < list.get(i)) return false;
//        }
//
//        return true;
//    }
//} // 160 ms