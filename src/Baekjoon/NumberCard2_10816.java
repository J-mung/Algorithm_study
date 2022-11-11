package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberCard2_10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            String input = tokens.nextToken();
            if(map.get(input) != null) {
                int prev = map.get(input);
                map.put(input, prev+1);
            } else
                map.put(input, 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuffer result = new StringBuffer();
        tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            String input = tokens.nextToken();
            if(map.get(input) != null)
                result.append(map.get(input) + " ");
            else
                result.append(0 + " ");
        }

        System.out.println(result);
    }
}
