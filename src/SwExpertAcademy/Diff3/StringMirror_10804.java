package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    ‘b’, ‘d’, ‘p’, ‘q’로 이루어진 문자열이 주어진다. 이 문자열을 거울에 비추면 어떤 문자열이 되는지 구하는 프로그램을 작성하라.

    예를 들어, “bdppq”를 거울에 비추면 “pqqbd”처럼 나타날 것이다.



    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 ‘b’, ‘d’, ‘p’, ‘q’만으로 이루어진 하나의 문자열이 주어진다. 문자열의 길이는 1이상 1000이하이다.

    2
    bdppq
    qqqqpppbbd

    [출력]
    각 테스트 케이스마다 주어진 문자열을 거울에 비춘 문자열로 출력한다.

    #1 pqqbd
    #2 bddqqqpppp

*/

public class StringMirror_10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int caseNum = sc.nextInt();

        for (int tc = 0; tc < caseNum; tc++) {
            char[] inputStr = sc.next().toCharArray();
            String result = "#" + (tc + 1) + " ";

            for (int i = inputStr.length - 1; i >= 0; i--) {
                switch (inputStr[i]) {
                    case 'b':
                        result += "d";
                        break;
                    case 'd':
                        result += "b";
                        break;
                    case 'p':
                        result += "q";
                        break;
                    case 'q':
                        result += "p";
                        break;
                }
            }

            builder.append(result + "\n");
        }
        System.out.println(builder);
    }
}
