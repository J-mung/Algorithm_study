package Baekjoon;

/*
        0   1   2           1   2   3
    0   0   1   2       1   1   2   3

    1   3   4   5       2   2   4   6

    2   6   7   8       3   3   6   9

    input
    3
    7

    output
    6

    if  (key < [i][j]) {
        어떤 값을 줄여야 할까
        i만 조절해서 찾을 수도 있고
        j만 조절해서 찾을 수도 있고
        둘 다 조절해서 찾을 수도 있고
    } else {

    }
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumber_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // x는 lo <= x <= hi 의 범위를 갖는다.
        long lo = 1;
        long hi = K;

        // lower-bound
        while(lo < hi) {
            long mid = (lo + hi) / 2;   // 임의의 x(mid)를 중간 값으로 잡는다.
            long count = 0;

            /*
            * 임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
            * 누적 합을 구한다.
            * 이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
            */
            
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻
            if (K <= count) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }
}
