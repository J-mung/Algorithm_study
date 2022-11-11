package SwExpertAcademy.Diff2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberArrayTurn_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens;
        StringBuffer buffer = new StringBuffer();

        // test case 개수
        int tc = Integer.parseInt(br.readLine());

        // solution 실행
        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            // 2차원 배열 입력
            for (int j = 0; j < N; j++) {
                tokens = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(tokens.nextToken());
                }
            }

            buffer.append("#" + (i + 1) + "\n");

            // 180도, 270도 회전 시에 감소하는 축으로 사용할 index
            int l = N - 1;

            for (int j = 0; j < N; j++) {

                // 90도 회전
                for (int k = N - 1; k >= 0; k--) {
                    buffer.append(arr[k][j]);
                }
                buffer.append(" ");

                // 180도 회전
                for (int k = N - 1; k >= 0 ; k--) {
                    buffer.append(arr[l][k]);
                }
                buffer.append(" ");

                // 270도 회전
                for (int k = 0; k < N; k++) {
                    buffer.append(arr[k][l]);
                }
                l--;
                buffer.append("\n");
            }
        }
        System.out.println(buffer);
    }
}
