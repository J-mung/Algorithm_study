/*
이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

[제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.

입출력 예
numbers	hand	result
[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */
package Kakao;

public class KeypadPress {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        String answer = "";

        // 키패드 0을 11로 변경. 이동 거리를 계산할 때 키패드의 숫자가 일정한 크기로 변동되야 하기 때문
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0) {
                numbers[i] = 11;
            }
        }

        int cur_left = 10;      // 왼쪽 손가락 시작 위치 *
        int cur_right = 12;     // 오른쪽 손가락 시작 위치 #

        for(int num : numbers) {
            switch(num) {
                case 1: case 4: case 7:         // 왼쪽열 키패드 왼손 입력
                    answer += "L";
                    cur_left = num;
                    break;
                case 3: case 6: case 9:         // 오른쪽열 키패드 오른손 입력
                    answer += "R";
                    cur_right = num;
                    break;
                default :                       // 가운데 키패드
                    // 왼손 오른손 각각이 현재 위치에서 눌러야 할 키패드로 이동할 거리를 구함
                    int left_move = calDistance(Math.abs(num - cur_left));
                    int right_move = calDistance(Math.abs(num - cur_right));

                    // 이동할 거리가 같으면 hand에 따라 결정
                    if(left_move == right_move) {
                        if(hand.equals("right")) {
                            answer += "R";
                            cur_right = num;
                        }
                        else {
                            answer += "L";
                            cur_left = num;
                        }
                    }
                    // 왼손이 이동 거리가 더 적으므로 L 입력
                    else if(left_move < right_move) {
                        answer += "L";
                        cur_left = num;
                    }
                    // 오른손이 이동 거리가 더 적으므로 R 입력
                   else {
                        answer += "R";
                        cur_right = num;
                    }
                    break;
            }
        }
        System.out.println(answer);
    }

    // 이동할 거리 계산
    static int calDistance(int sub) {
        int movement= 0;
        // 상하 이동
        while(sub >= 3) {
            sub -= 3;
            movement++;
        }
        // 좌우 이동
        while(sub >= 1) {
            sub -= 1;
            movement++;
        }
        return movement;
    }
}
