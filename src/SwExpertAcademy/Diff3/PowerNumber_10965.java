package SwExpertAcademy.Diff3;

import java.util.Scanner;

/*
    [설명]
    어떤 자연수 A가 주어진다. 여기에 자연수 B를 곱한 결과가 거듭제곱수가 되는 최소의 B를 구하는 프로그램을 작성하라. 여기서 자연수는 1이상인 정수를 뜻한다.

    [입력]
    첫 번째 줄에 테스트 케이스의 수 T 가 주어진다.
    각 테스트 케이스의 첫 번째 줄에는 하나의 자연수 A(1≤A≤10^7) 가 주어진다.

    8
    1
    2
    3
    4
    5
    6
    60
    1000

    [출력]
    각 테스트 케이스마다 A에 곱한 결과가 거듭제곱수가 되는 최소의 자연수를 출력한다.

    #1 1
    #2 2
    #3 3
    #4 1
    #5 5
    #6 6
    #7 15
    #8 10
*/

public class PowerNumber_10965 {
    private static final int MAX = 10000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int testCase = sc.nextInt();

        boolean[] nonPrime = new boolean[MAX];
        int[] primeNum = new int[3500];
        int primIdx = 0;
        int maxSqrt = (int) Math.sqrt(MAX - 1);

        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i < maxSqrt; i++) {
            if (nonPrime[i])
                continue;
            else
                primeNum[primIdx++] = i;
            for (int j = i * 2; j < MAX; j += i) {
                // 소수가 아닐 경우
                nonPrime[j] = true;
            }
        }

        int count, A, B;

        for (int tc = 0; tc < testCase; tc++) {
            String caseNumbering = "#" + (tc + 1) + " ";
            A = sc.nextInt();

            if(!nonPrime[A]) {
                builder.append(caseNumbering + A + "\n");
                continue;
            }

            int idx = 0;
            B = 1;

            // 소인수분해를 수행한 횟수
            count = 0;

            // 소인수 분해
            // 60 == 2^2 * 3 * 5;
            // 15를 60에 곱하면 2^2 * 3^2 * 5^2로 제곱근이 됌
            while (A > 1) {
                // 소인수분해가 가능할 경우
                if (A % primeNum[idx] == 0) {
                    count++;
                    A /= primeNum[idx];
                }

                // 소인수분해가 안 될 경우
                if (A % primeNum[idx] != 0) {

                    // 현재까지 소인수분해한 횟수 확인
                    if (count % 2 != 0) {

                        // 횟수가 짝수가 아니므로 현재 소수를 B에 곱함
                        B *= primeNum[idx];
                    }

                    // A가 현재 소수일 경우
                    if (!nonPrime[A]) {

                        // B에 A를 곱함
                        B *= A;
                        break;
                    }

                    // 다음 소수
                    idx++;

                    if (idx == primIdx) {
                        B *= A;
                        break;
                    }
                    count = 0;
                }
            }
            builder.append(caseNumbering + B + "\n");
        }
        System.out.println(builder);
    }
}
