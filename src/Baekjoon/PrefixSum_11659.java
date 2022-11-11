package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        int[] prefix = new int[N + 1];
        tokens = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(tokens.nextToken());
        }

        StringBuffer buffer = new StringBuffer();
        for (int k = 0; k < M; k++) {
            tokens = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(tokens.nextToken());
            int j = Integer.parseInt(tokens.nextToken());

            buffer.append(prefix[j] - prefix[i - 1]).append("\n");
        }

        System.out.println(buffer);
    }
}
