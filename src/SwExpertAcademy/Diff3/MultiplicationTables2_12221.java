package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    아기 석환이는 최근 구구단을 배웠다.

    그래서 1 이상 9 이하의 자연수 두개를 곱셈할 수 있으나, 10 이상의 자연수를 곱셈하는 방법은 모른다.

    두 정수 A, B가 주어진다. 아기 석환이 두 정수를 곱셈할 수 있으면 곱을 출력하고, 아니면 -1을 출력하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.

        ∙ 첫 번째 줄에 두 정수 A, B가 주어진다. (1 ≤ A, B ≤ 20)

    4
    2 5
    5 10
    10 10
    9 9

    [출력]
    각 테스트 케이스마다 정답을 출력하라.

    #1 10
    #2 -1
    #3 -1
    #4 81

*/

public class MultiplicationTables2_12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x >= 10 || y >= 10)
                System.out.println("#" + (i + 1) + " " + (-1));
            else
                System.out.println("#" + (i + 1) + " " + (x * y));
        }
    }
}
