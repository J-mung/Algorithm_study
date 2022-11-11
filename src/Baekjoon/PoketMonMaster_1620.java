package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class PoketMonMaster_1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        Map<String, String> map = new HashMap<>();
        String[] names = new String[N+1];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, String.valueOf(i+1));
            names[i+1] = input;
        }

        StringBuffer result = new StringBuffer();
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            byte[] c = input.getBytes();
            if(c[0] >= '0' && c[0] <= '9') {
                result.append(names[Integer.parseInt(input)] + "\n");
            } else {
                result.append(map.get(input) + "\n");
            }
        }

        System.out.println(result);
    }
}
