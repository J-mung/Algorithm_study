package Baekjoon;
/*
    input
    2
    -5 1 12 1
    7
    1 1 8
    -3 -1 1
    2 2 2
    5 5 1
    -4 5 1
    12 1 1
    12 1 2
    -5 1 5 1
    1
    0 0 2

    output
    3
    0

    주어진 행성계 안에 포인트가
    1) 아무것도 없을 때
        피해가면 되기 때문에 non-count
        departDisPow > r && arrivDisPow > r

    2) 출발지, 도착지 모두 있을 때
        진입, 진출 모두 하지 않으므로 non-count
        departDisPow < r && arrivDisPow < r

    3) 출발지, 도착지 중 1개가 있을 때
        이탈 혹은 진입 1회
        departDisPow < r || arrivDisPow < r

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLittlePrince_1004 {
    private static StringTokenizer tokens;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2;

        StringBuffer buffer = new StringBuffer();
        while(T --> 0) {
            tokens = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(tokens.nextToken());
            y1 = Integer.parseInt(tokens.nextToken());
            x2 = Integer.parseInt(tokens.nextToken());
            y2 = Integer.parseInt(tokens.nextToken());

            buffer.append(solution(x1, y1, x2, y2)).append("\n");
        }

        System.out.println(buffer);
    }

    public static int solution(int x1, int y1, int x2, int y2) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N --> 0) {
            tokens = new StringTokenizer(br.readLine());
            int x3 = Integer.parseInt(tokens.nextToken());
            int y3 = Integer.parseInt(tokens.nextToken());
            int r = Integer.parseInt(tokens.nextToken());
            
            boolean departDisPow = (Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2)) < Math.pow(r, 2) ? true : false;
            boolean arrivDisPow = (Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2)) < Math.pow(r, 2) ? true : false;

            // or 구문으로만 정답을 도출하지 못 함
            // and 구문으로 오답들이 걸러진다는 전제 하에 위의 주석으로 설명되는 or 구문으로 풀이가 가능함
            if(departDisPow != arrivDisPow) {
                count++;
            }
        }
        return count;
    }
}
