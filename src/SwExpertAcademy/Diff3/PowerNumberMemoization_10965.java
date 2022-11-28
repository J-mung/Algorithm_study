package SwExpertAcademy.Diff3;

import java.util.ArrayList;
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

public class PowerNumberMemoization_10965 {
    private static final int MAX = 10000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int testCase = sc.nextInt();

        // Memoization array list
        // -> 입력되는 A가 내림차순일 때는 빠를지도 모르지만 오름차순일 경우 더 많은 시간을 소요함
        ArrayList<Integer> arrList = new ArrayList<>();
        boolean[] nonPrime = new boolean[MAX];
        int[] primeNum = new int[3500];
        int idx;
        int pos = 0;

        for (int i = 2; i < Math.sqrt(MAX); i++) {
            if (nonPrime[i])
                continue;
            else
                primeNum[pos++] = i;
            for (int j = i * 2; j < MAX; j += i) {
                // 소수가 아니면
                nonPrime[j] = true;
            }
        }

        arrList.add(0, 0);
        arrList.add(1, 1);
        for (int tc = 0; tc < testCase; tc++) {
            int A = sc.nextInt();
            int B;

            while (true) {
                // 답을 메모해둔 숫자가 아니면
                if (arrList.size() <= A) {

                    // =============================Time Out===================================
                    int n = arrList.size();
                    while (n <= A) {
                        // 1부터 하나씩 탐색해서 시간 초과나는 듯
                        // 입력된 A가 소수면 B == A임 -> 소수를 미리 걸러내자
                        if (!nonPrime[n]) {
                            arrList.add(n, n);
                            n++;
                            continue;
                        }

                        // n이 소수가 아니면 소인수 분해
                        idx = 0;
                        B = 1;
                        int count = 0;
                        int tmpN = n;

                        while(tmpN > 1) {
                            if (tmpN % primeNum[idx] == 0) {
                                count++;
                                tmpN /= primeNum[idx];
                            }

                            if (tmpN % primeNum[idx] != 0) {
                                if (count % 2 != 0)
                                    B *= primeNum[idx];
                                if (!nonPrime[tmpN]) {
                                    B *= tmpN;
                                    break;
                                }
                                idx++;
                                if (idx == pos) {
                                    B *= tmpN;
                                    break;
                                }
                                count = 0;
                            }
                        }
                        arrList.add(n, B);
                        n++;
                        /*
                        // ===== 수정 중 =====
                        B = 1;
                        double tmp = Math.sqrt(n * B);
                        int essence = (int) Math.round(tmp);

                        while (essence - tmp != 0) {
                            B++;
                            tmp = Math.sqrt(n * B);
                            essence = (int) Math.round(tmp);
                        }
                        arrList.add(n, B);
                        n++;
                        // ===== 수정 중 =====
                        */
                    }
                    builder.append("#" + (tc + 1) + " " + arrList.get(A) + "\n");
                    break;
                    // =============================Time Out===================================
                } else {
                    builder.append("#" + (tc + 1) + " " + arrList.get(A) + "\n");
                    break;
                }
            }
        }
        System.out.println(builder);
    }
}
