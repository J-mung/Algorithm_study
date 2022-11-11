package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExitRectangle_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int[] input = new int[4];
        for(int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(tokens.nextToken());
        }

        input[2] = Math.abs(input[0] - input[2]);
        input[3] = Math.abs(input[1] - input[3]);

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            result = Math.min(result, input[i]);
        }

        System.out.println(result);
    }
}
