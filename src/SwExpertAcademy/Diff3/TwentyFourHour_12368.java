package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    하루는 24시간이다. 24시간제 시계에서는 하루가 자정에서 시작해서 다음 날 자정에서 끝나며,

    자정에서부터 지금까지 흐른 시간을 기준으로 시각을 표기한다. 예를 들어, 지금이 오후 8시라면 “20시”와 같은 꼴로 표현할 수 있다.

    자정을 표기하는 유일한 방법은 “0시”임에 유의하라.

    지금은 자정에서부터 정확히 A시간이 지났다. 앞으로 정확히 B시간이 더 지난다면, 24시간제 시계에서 그 때는 몇 시일까?

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 두 개의 정수 A, B (0 ≤ A, B ≤ 23)이 공백 하나를 사이로 두고 순서대로 주어진다.

    3
    1 9
    7 17
    23 23

    [출력]
    각 테스트 케이스마다, 현재 A시인 상황에서 앞으로 B시간이 지나면 몇 시가 되는지를 출력한다.

    #1 10
    #2 0
    #3 22
*/

public class TwentyFourHour_12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int result = (x + y) % 24;

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
