package SwExpertAcademy.Diff2;

import java.util.Scanner;

/*
    [설명]
    삼성전자에 입사한 종민이는 회사 근처로 이사를 하게 되었다.

    그런데 집의 위치가 두 수도 회사 A, B 중간에 위치하기에 원하는 수도 회사를 선택할 수 있게 되었는데,

    두 회사 중 더 적게 수도 요금을 부담해도 되는 회사를 고르려고 한다.

    종민이가 알아본 결과 두 회사의 수도 요금은 한 달 동안 사용한 수도의 양에 따라 다음과 같이 정해진다.

    A사 : 1리터당 P원의 돈을 내야 한다.

    B사 : 기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금만 청구된다.

    하지만 R 리터보다 많은 양을 사용한 경우 초과량에 대해 1리터당 S원의 요금을 더 내야 한다.

    종민이의 집에서 한 달간 사용하는 수도의 양이 W리터라고 할 때, 요금이 더 저렴한 회사를 골라 그 요금을 출력하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스마다 첫 번째 줄에 위 본문에서 설명한 대로

    P, Q, R, S, W(1 ≤ P, Q, R, S, W ≤ 10000, 자연수)가 순서대로 공백 하나로 구분되어 주어진다.

    2
    9 100 20 3 10
    8 300 100 10 250

    [출력]
    각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고, 종민이가 내야 하는 수도 요금을 출력한다.

    #1 90
    #2 1800
*/

public class WaterBillCompetition_1284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            // A사의 1리터당 P원
            int P = sc.nextInt();

            // B사의 기본 요금 Q
            int Q = sc.nextInt();

            // B사의 월간 사용량 R
            int R = sc.nextInt();

            // B사의 1리터당 추가 요금 S
            int S = sc.nextInt();

            // 종민이의 한 달간 사용량 W리터
            int W = sc.nextInt();

            int billA = P * W;
            int overUsing = W - R > 0 ? W - R : 0;
            int billB = Q + (overUsing * S);

            System.out.format("#%d %d\n", (i + 1), billA > billB ? billB : billA);
        }
    }
}
