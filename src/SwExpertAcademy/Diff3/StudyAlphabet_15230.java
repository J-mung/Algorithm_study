package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    영어 알파벳은 라틴 문자 중에서 영어에 쓰이는 문자로 ‘a’에서 ‘z’까지 총 26가지 문자가 있다. 정확한 목록과 순서는 다음과 같다.

    abcdefghijklmnopqrstuvwxyz

    어린 성훈이는 알파벳 공부를 하고 있어서, 몇 개의 알파벳을 적었다.

    성훈이가 적은 알파벳을 순서대로 보면서 앞에서부터 몇 개의 알파벳이 순서에 맞게 적혀 있는지 구하는 프로그램을 작성하라.

    단, 순서는 a부터 순서대로 일치하는 알파벳 개수를 계산하여야 한다.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 길이 1이상 26이하인 문자열이 주어진다.

    주어지는 문자열은 ‘a’에서 ‘z’까지의 문자로 이루어져 있다.

    [출력]
    각 테스트 케이스마다 순서에 맞게 적힌 알파벳 개수를 출력한다.

*/

public class StudyAlphabet_15230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < tc; i++) {
            String str = sc.next();
            int result = 0;
            int idx = 0;

            while (result < str.length()) {
                if (alpha.charAt(result) == str.charAt(idx)) {
                    result++;
                    idx++;
                }
                else
                    break;
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
