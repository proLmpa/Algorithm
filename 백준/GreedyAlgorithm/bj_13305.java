package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;
        int[] distances = new int[N];
        int[] fuels = new int[N+1];

        StringTokenizer distance = new StringTokenizer(br.readLine());
        StringTokenizer fuel = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            distances[i] = Integer.parseInt(distance.nextToken());
            fuels[i] = Integer.parseInt(fuel.nextToken());
        }
        fuels[N] = Integer.parseInt(fuel.nextToken());

        int sum = 0;
        int minCost = fuels[0];
        for(int i = 0; i < N; i++){
            if(fuels[i] < minCost){
                minCost = fuels[i];
            }
            sum += distances[i] * minCost;
        }

        System.out.print(sum);
    }
}