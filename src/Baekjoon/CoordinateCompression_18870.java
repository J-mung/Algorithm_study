package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CoordinateCompression_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        int[] ordered = new int[N];
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            ordered[i] = input[i];
        }

        Arrays.sort(ordered);

        map = new HashMap<>();
        int rank = 0;
        for(int i = 0; i < N; i++) {
            if(!map.containsKey(ordered[i]))
                map.put(ordered[i], rank++);
        }

        StringBuffer result = new StringBuffer();
        for(int i = 0; i < N; i++) {
            result.append(map.get(input[i]) + " ");
        }

        System.out.println(result);
    }
}
