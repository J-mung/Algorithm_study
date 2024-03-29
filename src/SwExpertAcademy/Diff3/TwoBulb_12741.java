package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    두 개의 전구 X와 Y가 있다. 당신은 0초에서부터 시작하여 100초간 두 전구가 언제 켜지는지를 관찰하였다.

    관찰 결과, 전구 X는 관찰 시작 경과 후 A초에서부터 관찰 시작 경과 후 B초까지에만 켜져 있었다.

    전구 Y는 관찰 시작 경과 후 C초에서부터 관찰 시작 경과 후 D초까지에만 켜져 있었다.

    당신이 두 전구를 관찰하던 100초 중 두 전구가 동시에 켜져 있던 시간은 몇 초일까?

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

    각 테스트 케이스의 첫 번째 줄에는 네 개의 정수 A, B, C, D (0 ≤ A < B ≤ 100, 0 ≤ C < D ≤ 100)가 공백 하나를 사이로 두고 순서대로 주어진다.

    3
    1 3 5 7
    0 5 2 4
    0 5 1 6

    [출력]
    각 테스트 케이스마다, 두 전구가 동시에 켜져 있던 시간이 몇 초인지를 한 줄에 하나씩 출력한다.

    #1 0
    #2 2
    #3 4
*/

public class TwoBulb_12741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();

			/*boolean[] time = new boolean[100];
			boolean XOnOff = false;
			boolean YOnOff = false;

			for (int j = 0; j < 100; j++) {
				if (A == j) {
					XOnOff = true;
				}
				if (B == j) {
					XOnOff = false;
				}
				if (C == j) {
					YOnOff = true;
				}
				if (D == j) {
					YOnOff = false;
				}

				if (XOnOff && YOnOff) {
					time[j] = true;
				}
			}

			int result = 0;
			for (int j = 0; j < 100; j++) {
				result += time[j] ? 1 : 0;
			}
			*/

            int result = Math.min(B, D) - Math.max(A, C);

            System.out.println("#" + (i + 1) + " " + result);
        }

    }
}
