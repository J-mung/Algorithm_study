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
        int median = 10000;
        int mode = 10000;

        for(int i = 0; i < length; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[value + 4000]++;
            sum += value;

            if(max < value)
                max = value;
            if(min > value)
                min = value;
        }

        int count = 0;
        int mode_max = 0;

        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {
                if(count < (length+1)/2) {
                    count += arr[i];
                    median = i-4000;
                }

                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                } else if(arr[i] == mode_max && flag == true) {
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
