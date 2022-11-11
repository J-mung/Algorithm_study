package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class StringSet_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, input);
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            if(map.containsKey(str))
                result++;
        }

        System.out.println(result);
        br.close();
    }
}
