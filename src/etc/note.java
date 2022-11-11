package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class note {
    private static boolean[] visit;
    private static int[] arr;
    private static int N, M;
    private static StringBuffer buffer = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        visit = new boolean[N];
        arr = new int[M];

        dfs(1, 0);
        System.out.println(buffer);
    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : arr) {
                buffer.append(val).append(" ");
            }
            buffer.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
