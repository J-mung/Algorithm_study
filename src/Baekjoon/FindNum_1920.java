package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum_1920 {
    private static int[] binary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;

        N = Integer.parseInt(br.readLine());
        binary = new int[N];
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            binary[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(binary);

        M = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < M; i++) {
            int token = Integer.parseInt(tokens.nextToken());
            if (searchNum(token)) {
                buffer.append(1).append('\n');
            } else {
                buffer.append(0).append('\n');
            }
        }

        System.out.println(buffer);
    }

    public static boolean searchNum(int num) {
        int left = 0;
        int right = binary.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int some = binary[mid];
            if (some < num) {
                left = mid + 1;
            } else if (some > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
