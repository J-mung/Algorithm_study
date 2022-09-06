package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
    가장 많은 회의를 배정하는 경우의 수를 찾는 것

    시작 시간보다 빠르게 끝나는 회의들 중에서
    가장 늦게 시작하는 것을 선택하도록 한다.
*/

public class MeetingRoom_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(tokens.nextToken());
            meetings[i][1] = Integer.parseInt(tokens.nextToken());
        }

        // 시작 시간을 기준으로 정렬하되, 시작 시간이 동일하면
        // 종료 시간으로 정렬한다. (오름차순)
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        // 덕분에 종료 시간이 동일해도 시작 시간이 늦는 회의를 고르게 됨.
        // 예) (A) 11-14, (B) 12-14
        // 회의 시간이 짧은 (B) 선택

        int answer = 1;
        int curTime = meetings[N - 1][0];

        // 최대한 많은 회의를 배정하기 위해서 뒤에서 부터 탐색.
        for (int i = N - 1; i > 0; i--) {

            // 회의 시간이 짧으면서 현재 회의 보다 먼저 끝나는 것 선택
            if (curTime >= meetings[i - 1][1]) {
                answer++;
                curTime = meetings[i - 1][0];
            }
        }

        System.out.println(answer);
    }
}
