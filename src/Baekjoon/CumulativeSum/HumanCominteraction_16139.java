package Baekjoon.CumulativeSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HumanCominteraction_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[26][str.length() + 1];

        for (int i = 1; i < str.length() + 1; i++) {
            int charAsc = str.charAt(i - 1) - 97;
            arr[charAsc][i] += 1;
            for (int j = 0; j < 26; j++) {
                arr[j][i] += arr[j][i - 1];
            }
        }

        StringTokenizer tokens;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            tokens = new StringTokenizer(br.readLine());
            int intChar = (int) tokens.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken());

            result.append(arr[intChar][r + 1] - arr[intChar][l]).append("\n");
        }

        System.out.println(result);
    }
}
