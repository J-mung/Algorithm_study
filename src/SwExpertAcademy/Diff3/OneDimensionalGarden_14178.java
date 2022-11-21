package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    1차원 수직선 위에 정원이 있다. 모든 정수 1 ≤ i ≤ N 에 대해, 좌표 i에 꽃이 하나씩 심겨 있다.

    즉, 좌표 1, 2, …, N에 총 N개의 꽃이 심겨 있다.

    꽃에 물을 주기 위해 자동 분무기를 사용한다.

    분무기는 정수 좌표에 놓을 수 있으며, 좌표 x에 분무기를 놓았을 경우 닫힌 구간 [x - D, x + D]에 심긴 모든 꽃들에 물을 줄 수 있다.

    N과 D가 주어질 때, 모든 꽃이 한 개 이상의 분무기에서 물을 받을 수 있도록 하기 위해 필요한 최소한의 분무기 수를 구하는 프로그램을 작성하라.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스는 하나의 줄로 이루어진다.

    각 줄에는 두 개의 정수 N과 D (1 ≤ N, D ≤ 100) 가 공백 하나를 사이로 두고 주어진다.

    3
    5 1
    5 2
    100 3

    [출력]
    각 테스트 케이스마다 모든 꽃이 한 개 이상의 분무기에서 물을 받을 수 있도록 하기 위해 필요한 최소한의 분무기 수를 출력한다.

    #1 2
    #2 1
    #3 15
*/

public class OneDimensionalGarden_14178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int D = (sc.nextInt() * 2) + 1;
            int result = 0;

            while (N > 0) {
                N -= D;
                result++;
            }

            System.out.format("#%d %d\n", i + 1, result);
        }

    }
}
