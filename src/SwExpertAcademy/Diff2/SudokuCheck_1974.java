package SwExpertAcademy.Diff2;

import java.util.Scanner;

public class SudokuCheck_1974 {

    // 스도쿠 사이즈
    private static final int SIZE = 9;

    // 사용 여부 판단 배열 사이즈
    private static final int CHECK_SIZE = 10;

    // 스도쿠
    private static int[][] sudoku = new int[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            // 스도쿠 입력
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    sudoku[j][k] = sc.nextInt();
                }
            }

            // 풀이
            int result = solve();

            // 결과 값 출력
            System.out.println("#" + (i + 1) + " " + result);
        }
    }

    private static int solve() {

        // 가로 확인용 배열
        boolean[] rowUsed;

        // 세로 확인용 배열
        boolean[] colUsed;

        // 가로 세로 확인
        for (int i = 0; i < SIZE; i++) {

            // 배열 초기화
            rowUsed = new boolean[CHECK_SIZE];
            colUsed = new boolean[CHECK_SIZE];
            for (int j = 0; j < SIZE; j++) {

                // 가로 혹은 세로 확인용 배열에서 이미 사용한 숫자가 검출되면
                if (rowUsed[sudoku[i][j]] || colUsed[sudoku[j][i]]) {

                    // 실패(0) 반환
                    return 0;
                }
                
                // 사용한 숫자 메모
                rowUsed[sudoku[i][j]] = true;
                colUsed[sudoku[j][i]] = true;
            }
        }

        // 3x3 구역 확인용 배열
        boolean[] squareUsed;
        
        // 3x3 구역 확인
        for (int i = 0; i < SIZE; i += 3) {
            for (int j = 0; j < SIZE; j += 3) {
                
                // 배열 초기화
                squareUsed = new boolean[CHECK_SIZE];
                
                // 3x3 구역별로 확인
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {

                        // 3x3 구역 확인용 배열에서 이미 사용한 숫자가 검출되면
                        if (squareUsed[sudoku[i + k][j + l]]) {
                            
                            // 실패(0) 반환
                            return 0;
                        }
                        
                        // 사용한 숫자 메모
                        squareUsed[sudoku[i + k][j + l]] = true;
                    }
                }
            }
        }

        // 성공(1) 반환
        return 1;
    }
}
