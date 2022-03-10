package Baekjoon;

import java.util.Scanner;

public class RepaintingChessBoard_1018 {

    // 체스보드 패턴
    public static char[][] black = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
    };
    public static char[][] white = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
    };

    public static void main(String[] args) {

        int row, col, answer;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        String[] str = new String[row];

        // board 입력
        for(int i = 0; i < row; i++) {
            str[i] = sc.next();
        }

        answer = 9999;
        // row by col 행렬
        // 잘라야 하는 board의 시작 위치로 활용하므로 입력받은 값에 -8까지 동작
        for(int i = 0; i <= row-8; i++) {
            for(int j = 0; j <= col-8; j++) {
                int caseBlock = 0;  // case_black에서 덧칠해야 하는 사각형 개수
                int caseWhite = 0;  // case_white에서 덧칠해야 하는 사각형 개수
                int rowIdx = 0;        // 체스보드 패턴의 행 idx

                // 8 by 8 체스보드
                for(int k = i; k < i+8; k++) {
                    int colIdx = 0;     // 체스보드 패턴의 열 idx
                    for(int l = j; l < j+8; l++) {
                        // case_black
                        if(str[k].charAt(l) != black[rowIdx][colIdx])
                            caseBlock++;
                        // case_white
                        if(str[k].charAt(l) != white[rowIdx][colIdx++])
                            caseWhite++;
                    }
                    // 체스보드 패턴의 행 idx 반전
                    rowIdx = -rowIdx + 1;
                }
                // case_white, case_black 중에서 작은 값 저장
                if(answer > caseBlock)
                    answer = caseBlock;
                if(answer > caseWhite)
                    answer = caseWhite;
            }
        }

        System.out.println(answer);
    }
}
