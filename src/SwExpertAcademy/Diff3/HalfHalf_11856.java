package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    길이 4의 알파벳 대문자로 이루어진 문자열 S가 주어졌을 때, S에 정확히 두 개의 서로 다른 문자가 등장하고,

    각 문자가 정확히 두 번 등장하는 지 판별하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.
        ∙ 첫 번째 줄에 문자열 S가 주어진다.

    5
    ABAB
    CCDD
    EFFE
    EEEE
    NONE

    [출력]
    각 테스트 케이스마다
        ∙ 조건이 만족되면 “Yes”, 아니면 “No” 를 출력하라.

    #1 Yes
    #2 Yes
    #3 Yes
    #4 No
    #5 No
*/


public class HalfHalf_11856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            char[] inputs = sc.next().toCharArray();
            char[] alpha = new char[26];

            for (int j = 0; j < 4; j++) {
                alpha[inputs[j] - 'A']++;
            }

            String result = "Yes";
            for (int j = 0; j < 26; j++) {
                if (alpha[j] != 0 && alpha[j] != 2)
                    result = "No";
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
