package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    보드에 그려진 다트 게임을 생각해보자.

    보드에는 중심이 원점이고 반지름이 20,40,60,80,100,120,140,160,180,200 (단위는 mm)인 10개의 원이 그려져 있다.

    각각의 화살은 꽂힌 지점을 감싸는 가장 가까운 원(경계선에 꽂힌 경우도 포함)의 반지름이 20 * (11 - p)인 경우 p점을 획득한다. (1 ≤ p ≤ 10)

    만약 가장 큰 원 바깥에 꽂혔다면 얻는 점수는 없다. N 개의 화살을 던진 위치가 주어지면, 총 몇 점을 얻었는지 계산하자.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.
        -  첫 번째 정수는 화살의 개수 N이다. (1 ≤ N ≤ 1000000)
        -  이후 화살이 떨어진 위치 (x, y) 가 두 정수로 주어진다. (-200 ≤ x, y ≤ 200)

    1
    5
    80 -14
    117 12
    98 -69
    -86 21
    -121 99

    [출력]
    각 테스트 케이스마다 점수의 합을 출력하라.

    #1 25

    distance == 0 -> 10점
             == 20.0 -> 10점
             == 20.1 -> 9점
             == 200.0 -> 1점
             == 200.1 -> 0점
*/

public class DartGame_11285 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int dartNum = sc.nextInt();
            int result = 0;
            for (int dart = 0; dart < dartNum; dart++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                // 꽂힌 지점
                double pluggedPow = (x * x) + (y * y);

                // 제곱근(sqrt)를 사용하지 않고 점수 확인
                int d = 0;
                for (d = 20; d <= 200; d += 20) {
                    if (d*d >= pluggedPow)
                        break;
                }

                // p = 11 - tmp
                int p = 11 - d / 20;

                System.out.println("Dart : " + d + ", " + "point : " + p);
                result += p;
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
