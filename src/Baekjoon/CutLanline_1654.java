package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutLanline_1654 {
    public static int K;
    public static int N;
    public static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        K = Integer.parseInt(tokens.nextToken());
        N = Integer.parseInt(tokens.nextToken());
        lines = new int[K];
        long max = -9999;
        for(int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if(max < lines[i])
                max = lines[i];
        }

        Cut(++max);
    }

    public static void Cut(long max) {
        long min = 0;
        while(min < max) {
            long mid = (min + max) / 2;
            long total = cutLine(mid);
            if(total < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

    public static long cutLine(long cm) {
        long total = 0;
        for (int i = 0; i < K; i++) {
            total += lines[i] / cm;
        }
        return total;
    }
}
