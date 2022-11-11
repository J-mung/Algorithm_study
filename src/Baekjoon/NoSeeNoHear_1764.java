package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NoSeeNoHear_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < N+M; i++) {
            String input = br.readLine();
            if(map.get(input) != null) {
                int val = map.get(input);
                map.put(input, val+1);
            } else
                map.put(input, 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) > 1) {
                list.add(key);
            }
        }

        Collections.sort(list);

        int size = list.size();
        StringBuffer result = new StringBuffer();
        result.append(size + "\n");
        for(int i = 0; i < size; i++) {
            result.append(list.get(i) + "\n");
        }
        System.out.println(result);
    }
}
