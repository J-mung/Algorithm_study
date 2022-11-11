package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    4 다음에 1 이면 ┏
    3 다음에 2 이면 ┛
    2 다음에 4 이면 ㄴ
    1 다음에 3 이면 ㄱ
*/

public class MelonField_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxWidth = 0, maxWidthIdx = 0;
        int maxHeight = 0, maxHeightIdx = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(tokens.nextToken());
            arr[i] = Integer.parseInt(tokens.nextToken());

            // 가장 긴 가로의 길이와 위치 찾기
            if ((dir == 1 || dir == 2) && maxWidth < arr[i]) {
                maxWidth = arr[i];
                maxWidthIdx = i;
            }
            // 가장 긴 세로의 길이와 위치 찾기
            else if ((dir == 3 || dir == 4) && maxHeight < arr[i]) {
                maxHeight = arr[i];
                maxHeightIdx = i;
            }
        }

        int right, left, minWidth, minHeight;

        right = (maxWidthIdx + 1) % 6;
        left = (maxWidthIdx - 1) < 0 ? 5 : maxWidthIdx - 1;
        // 빈 사각형의 세로 길이
        minHeight = Math.abs(arr[right] - arr[left]);

        right = (maxHeightIdx + 1) % 6;
        left = (maxHeightIdx - 1) < 0 ? 5 : maxHeightIdx - 1;
        // 빈 사각형의 가로 길이
        minWidth = Math.abs(arr[right] - arr[left]);

        System.out.println(((maxWidth * maxHeight) - (minHeight * minWidth)) * N);
    }
}
