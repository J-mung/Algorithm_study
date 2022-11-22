package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    1 이상 N 이하의 정수가 적혀 있는 길이 N의 순열 p1, p2, …, pN이 있다.

    수열에 있는 모든 숫자는 서로 다르다. 2 ≤ i ≤ N-1이며, pi-1, pi, pi+1 중 pi가 선택된 3개의 값에서 최솟값도, 최댓값도 아니라면 pi를 평범한 숫자라고 정의한다.

    주어진 순열에서 평범한 숫자의 개수는 몇 개인가?

    [입력]
    첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.

    각 테스트 케이스는 다음과 같이 구성되었다.
        ∙ 첫 번째 줄에 정수 N 이 주어진다. (3 ≤ N ≤ 20)
        ∙ 이후 N개의 정수 pi가 주어진다. (3 ≤ pi ≤ N) 모든 pi는 서로 다르다.

    2
    3
    1 3 2
    5
    1 3 5 4 2

    [출력]
    각 테스트 케이스마다 정답을 출력하라.

    #1 0
    #2 2
*/

public class NormalNumber_11736 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int result = 0;
            for (int j = 1; j < N - 1; j++) {
                if (arr[j - 1] > arr[j] && arr[j + 1] < arr[j]) {
                    result++;
                }
                else if (arr[j - 1] < arr[j] && arr[j + 1] > arr[j]) {
                    result++;
                }
            }

            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
