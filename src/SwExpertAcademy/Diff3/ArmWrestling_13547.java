package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    소정이와 세정이는 점심 값을 누가 낼 지 정하기 위해 팔씨름을 하기로 했다.

    공정하고 재밌는 경기를 위해 둘은 15번 팔씨름을 하여 8번 이상 이기는 사람이 점심 값을 면제받기로 하였다.

    둘은 지금까지 k번의 팔씨름을 진행했다. 이 결과는 길이가 k인 ‘o’ 또는 ‘x’로만 구성된 문자열 S[1..k]로 나타낼 수 있다.

    S[i]가 ‘o’면 소정이가 i번째 경기에서 승리했다는 것이고, ‘x’면 패배했다는 것이다.

    소정이는 앞으로 팔씨름을 15번째 경기까지 진행했을 때 자신이 점심값을 면제받을 가능성이 있는지 알고자 한다.

    이를 대신해 주는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스는 하나의 줄로 이루어진다.

    각 줄에는 ‘o’ 또는 ‘x’로만 구성된 길이가 1 이상 15 이하인 문자열 S가 주어진다.

    3
    oxoxoxoxoxoxoxo
    x
    xxxxxxxxxxxx

    [출력]
    각 테스트 케이스마다, 소정이가 점심값을 면제받을 가능성이 있다면 ‘YES’, 없다면 ‘NO’를 출력한다.

    #1 YES
    #2 YES
    #3 NO

*/


public class ArmWrestling_13547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            char[] inputs = sc.next().toCharArray();

            int lose = 0;

            for (int j = 0; j < inputs.length; j++) {
                lose += inputs[j] == 'x' ? 1 : 0;
            }

            if (lose <= 7) {
                System.out.format("#%d %s\n", i + 1, "YES");
            } else {
                System.out.format("#%d %s\n", i + 1, "NO");
            }
        }

    }
}
