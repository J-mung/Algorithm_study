package Baekjoon;

import java.io.*;
import java.util.ArrayList;

public class Statistics_2108 {
    private final static int MAX_NUM = 8000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX_NUM+1];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int median = 10000;             // 중앙값
        int mode = 10000;               // 최빈값

        /*
        * Counting sort는 잠정적인 위치를 표방하고 있음
        * 따라서 등장 횟수를 셈하는 arr의 요소를 중첩하며,
        * 중첩값이 (length + 1) / 2와 일치하게 되면 중앙값을 구할 수 있음.
        * */

        for(int i = 0; i < length; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value + 4000]++;
            sum += value;

            if(max < value)
                max = value;
            if(min > value)
                min = value;
        }

        int count = 0;                  // 중앙값 빈도 누적 수
        int mode_max = 0;               // 최빈값의 최댓값

        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {
                if(count < (length+1)/2) {
                    count += arr[i];
                    median = i-4000;
                }

                // 이전 최빈값 보다 현재의 최빈값이 큰 경우
                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                // 현재 최빈값과 동일한 최빈값이 나왔으며, 한 번만 중복되는 경우
                else if(arr[i] == mode_max && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        bw.write(String.valueOf((int)Math.round((double)sum/length)));
        bw.newLine();
        bw.write(String.valueOf(median));
        bw.newLine();
        bw.write(String.valueOf(mode));
        bw.newLine();
        bw.write(String.valueOf(max - min));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
