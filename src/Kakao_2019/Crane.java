/*
[제한사항]
board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
0은 빈 칸을 나타냅니다.
1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
moves 배열의 크기는 1 이상 1,000 이하입니다.
moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

입출력 예
board	moves	result
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
 */

package Kakao_2019;

import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        int[][]board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        //int[][]board = {{0,2,0}, {1,2,0}, {2,2,1}};
        //int[] moves = {2,2,2,2,2,2};
        final int BOARD_SIZE = board[0].length;
        int[] indexing = new int[board[0].length];
        Stack<Integer> box = new Stack<Integer>();
        int answer = 0;

        // NxN의 특정 열에서 인형이 처음 등장하는 위치 마킹
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if(board[j][i] == 0) {
                    indexing[i]++;
                }
            }
        }
        // 마킹 확인용
        for(int idx : indexing) {
            System.out.println(idx);
        }

        boolean confirm = false;           // 인형 비교 생략 여부
        for(int move : moves) {
            if(box.isEmpty()) {         // 스택이 비었을 경우 box top과 크레인이 끌어올린 인형 비교 생략
                confirm = false;
            }
            if(confirm && (box.peek() == board[indexing[move-1]][move-1])) {     // 만약 top과 크레인이 끌어올린 인형이 동일하다면,
                box.pop();                                  // box에 있는 인형과
                board[indexing[move - 1]][move - 1] = 0;    // 끌어올린 인형 boom!
                answer += 2;                                // 인형 카운트
                indexing[move - 1]++;                       // 해당 열의 인형을 하나 끌어올렸으므로, 마킹 이동
                confirm = true;
            }
            else {                                                          // 비교를 생략했거나, 인형들이 동일하지 않다면, 인형 삽입
                if(board[indexing[move-1]][move-1] != 0) {                  // 해당 열에 인형이 존재할 때에만
                    box.push(board[indexing[move - 1]][move - 1]);          // box에 삽입
                    board[indexing[move-1]][move-1] = 0;                    // 인형이 사라졌음을 표시
                    indexing[move - 1]++;                                   // 해당 열의 인형을 하나 끌어올렸으므로, 마킹 이동
                }
                confirm = true;
            }
            if(indexing[move-1] >= BOARD_SIZE) {            // 만약 마킹이 배열의 길이를 벗어나면
                indexing[move-1] = BOARD_SIZE-1;            // 초기화
            }
        }
        System.out.println("answer : " + answer);
    }
}
