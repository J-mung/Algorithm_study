package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class FindWordPosition_1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] matrix = new int[N][N];

            // 퍼즐 입력
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            // 결과 값
            int result = 0;

            // 가로 체크
            for (int j = 0; j < N; j++) {
                int col = 0;

                for (int k = 0; k < N; k++) {

                    // 현재 퍼즐 위치가 검은색일 경우
                    if (matrix[j][k] == 0) {

                        // 가로 길이 확인
                        if(col == K) {
                            result++;
                        }

                        // 현재까지의 길이 초기화
                        col = 0;
                    } else {

                        // 현재 퍼즐 위치가 하얀색일 경우
                        col += 1;
                    }
                }

                // 퍼즐 끝까지 검은색이 나오지 않았으며, 현재까지의 가로 길이가 K와 동일할 경우
                if (col == K) {
                    result++;
                }
            }

            // 세로 체크
            for (int j = 0; j < N; j++) {
                int row = 0;

                for (int k = 0; k < N; k++) {

                    // 현재 퍼즐 위치가 검은색일 경우
                    if (matrix[k][j] == 0) {

                        // 세로 길이 확인
                        if(row == K) {
                            result++;
                        }

                        // 현재까지의 길이 초기화
                        row = 0;
                    } else {

                        // 현재 퍼즐 위치가 하얀색일 경우
                        row += 1;
                    }
                }

                // 퍼즐 끝까지 검은색이 나오지 않았으며, 현재까지의 세로 길이가 K와 동일할 경우
                if (row == K) {
                    result++;
               }
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
