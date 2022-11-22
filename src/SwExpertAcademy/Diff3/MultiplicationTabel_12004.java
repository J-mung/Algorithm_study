package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    정수 N이 주어졌을 때, N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있는지 판단하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.

        ∙ 하나의 정수 N이 주어진다. (1≤N≤100)

    4
    10
    11
    50
    81

    [출력]
    각 테스트 케이스마다
        ∙ N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있으면 “Yes”, 아니면 “No” 를 출력하라.

    #1 Yes
    #2 No
    #3 No
    #4 Yes
*/

public class MultiplicationTabel_12004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();

            String result = "No";
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (j * k == N)
                        result = "Yes";
                }
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
