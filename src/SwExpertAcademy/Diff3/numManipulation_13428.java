package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    9자리 이하의 음이 아닌 정수 N이 있다.

    당신은 이 수에서 한 쌍의 숫자를 골라 그 위치를 바꾸는 일을 최대 한 번 하여(안 하거나, 한 번만 하여) 새로운 수 M을 만들 수 있다.

    단, 바꾼 결과 M의 맨 앞에 ‘0’이 나타나면 안 된다.

    M의 최솟값과 최댓값을 구하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스는 하나의 줄로 이루어진다. 각 줄에는 0 이상 999,999,999 이하의 정수 N이 주어진다.

    N ≠ 0 이라면 주어지는 수가 0으로 시작하지 않는다.

    4
    12345
    54321
    142857
    10000

    [출력]
    각 테스트 케이스마다, M의 최솟값과 최댓값을 공백 하나를 사이로 두고 출력한다.

    #1 12345 52341
    #2 14325 54321
    #3 124857 842157
    #4 10000 10000

*/

public class numManipulation_13428 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            char[] input = sc.next().toCharArray();
            int length = input.length;

            if (input[0] != '0') {
                String strMax = "0";
                String strMin = "999999999";
                char[] tmpMax;
                char[] tmpMin;
                for (int j = 0; j < length; j++) {
                    for (int k = 0; k < length; k++) {
                        tmpMax = input.clone();
                        tmpMin = input.clone();

                        char tmp = tmpMax[k];
                        tmpMax[k] = tmpMax[j];
                        tmpMax[j] = tmp;

                        tmp = tmpMin[k];
                        tmpMin[k] = tmpMin[j];
                        tmpMin[j] = tmp;

                        if (strMax.compareTo(String.valueOf(tmpMax)) < 0) {
                            strMax = String.valueOf(tmpMax);
                        }
                        if (strMin.compareTo(String.valueOf(tmpMin)) > 0 && tmpMin[0] != '0') {
                            strMin = String.valueOf(tmpMin);
                        }
                    }
                }

                System.out.format("#%d %s %s\n", i + 1, strMin, strMax);
            } else
                System.out.format("#%d %s %s\n", i + 1, "0", "0");
        }

    }
}
