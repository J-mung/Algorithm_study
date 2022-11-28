package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    알파벳 소문자 만으로 이루어진 문자열이 주어진다.

    이 문자열에서 같은 두 문자들을 짝짓고 남는 문자가 무엇인지 구하는 프로그램을 작성하라.

    같은 문자를 여러 번 짝지어서는 안 된다.



    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 알파벳 소문자 만으로 이루어진 문자열이 주어진다.

    이 문자열의 길이는 1이상 100이하이다.

    6
    xxyyzz
    yc
    aaaab
    bca
    ppzqq
    qnwerrewmq


    [출력]
    각 테스트 케이스 마다 예제와 같은 형식으로 남는 문자를 사전 순서대로 출력한다.

    만약 어떤 문자도 남지 않는다면 “Good”을 출력하도록 한다.

    #1 Good
    #2 cy
    #3 b
    #4 abc
    #5 z
    #6 mn
*/

public class LonelyCharacter_10912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {
            String caseNumbering = "#" + (tc + 1) + " ";
            char[] str = sc.next().toCharArray();
            int[] alph = new int[26];

            for (int i = 0; i < str.length; i++) {
                alph[str[i] - 'a']++;
            }
            String ans = "";
            for (int i = 0; i < 26; i++) {
                if (alph[i] % 2 != 0) {
                    ans += (char) ('a' + i);
                }
            }

            if (ans.equals("")) {
                builder.append(caseNumbering + "Good" + "\n");
            } else {
                builder.append(caseNumbering + ans + "\n");
            }
        }
        System.out.println(builder);
    }
}
