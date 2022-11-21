package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    오늘의 요일을 나타내는 문자열 S가 주어진다. S는 “MON”(월), “TUE”(화), “WED”(수), “THU”(목), “FRI”(금), “SAT”(토), “SUN”(일) 중 하나이다.

    다음 (즉, 내일 이후의 가장 빠른) 일요일까지는 며칠 남았을까?


    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스는 하나의 줄로 이루어진다. 각 줄에는 문자열 S가 주어진다.

    3
    SUN
    SAT
    MON

    [출력]
    각 테스트 케이스마다, 다음 일요일까지 며칠 남았는지를 한 줄에 하나씩 출력한다.

    #1 7
    #2 1
    #3 6
*/

public class Sunday_13229 {
    private static enum DAY {MON, TUE, WED, THU, FRI, SAT, SUN}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            String inputDay = sc.next();

            int result = 7 - (DAY.valueOf(inputDay).ordinal() + 1);

            if (result == 0)
                System.out.println("#" + (i + 1) + " " + 7);
            else
                System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
