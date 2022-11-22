package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    영어 알파벳으로 만들 수 있는 모든 단어(그것이 뜻이 없어도)가 수록된 무한 사전이 있다.

    두 단어 P, Q가 주어질 때, 사전 상에서 P와 Q사이에 다른 단어가 있는지 없는지 판별하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
    각 테스트 케이스의 첫 번째 줄에는 알파벳 소문자로 이루어진 단어 P가 주어진다.

    두 번째 줄에는 알파벳 소문자로 이루어진 단어 Q가 주어진다.
    P와 Q의 길이는 1이상 10이하이며, P는 Q보다 사전 상에서 먼저 오는 단어다.
    (단, 사전에는 10자보다 더 긴 단어가 존재 할 수 있다.)

    2
    cat
    dog
    man
    mana

    [출력]
    각 테스트 케이스마다 용사가 사전 상에서 P와 Q사이에 다른 단어가 있다면 “Y”를, 아니면 “N”를 출력한다.

    #1 Y
    #2 N
*/

public class InfiniteDictionary_11445 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String p = sc.next();
            String q = sc.next();

            // 사전 순
            // a, aa, aaa, aaaa, ..., b, bb, bbb, ...

            // 입력된 두 단어의 길이가 동일하고
            if (p.length() == q.length()) {

                // 입력된 P와 Q가 서로 다르면
                // aaa, aab 와 같은 케이스 이므로 Y
                if (!p.equals(q))
                    System.out.println("#" + test_case + " Y");
            }
            // 입력된 두 단어의 길이가 다르면
            else {

                // P의 마지막에 a 추가
                p = p + "a";

                // 입력된 두 단어의 길이가 동일해지면
                if (p.equals(q)) {

                    // man, mana 와 같은 케이스 이므로 N
                    System.out.println("#" + test_case + " N");
                }
                // 입력된 두 단어의 길이가 서로 다르면
                else {
                    // man, manaa 혹은 man, manb 와 같은 케이스 이므로 Y
                    System.out.println("#" + test_case + " Y");
                }
            }

        }
    }
}
