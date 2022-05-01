package Baekjoon;

import java.io.*;

/*
* 수의 범위를 알고 입출력만 하면 되는 상황이라면 입력되는 값을 array의 인덱스를 사용하요
* array 배열 값을 증가시킨 뒤, 누적 합 부분을 건너뛰고 바로 array[0] 부터
* 해당 인덱스의 값이 0이 될 때까지 인덱스를 출력하면 됨
* */

public class Sorting3_10989 {

    private static final int MAX_NUM = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] count = new int[MAX_NUM+1];

        for(int i = 0; i < length; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 0; i < count.length;) {
            if(count[i] != 0) {
                bw.write(String.valueOf(i));
                count[i]--;
                bw.newLine();
            } else {
                i++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
