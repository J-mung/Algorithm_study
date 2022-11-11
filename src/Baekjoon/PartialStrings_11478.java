package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PartialStrings_11478 {

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int size = input.length();
        for(int i = 1; i <= size; i++) {
            for(int j = 0; j+i <= size; j++) {
                String str = input.substring(j, j+i);
                /*if(map.get(str) == null) {
                    map.put(str, 1);
                }*/
                set.add(str);
            }
        }

        //int result = map.keySet().size();
        int result = set.size();
        System.out.println(result);
    }
}
