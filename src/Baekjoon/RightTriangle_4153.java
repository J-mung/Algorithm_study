package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RightTriangle_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] triangle = new int[3];
        StringBuffer buffer = new StringBuffer();

        while(true) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                triangle[i] = Integer.parseInt(tokens.nextToken());
            }

            Arrays.sort(triangle);

            if(triangle[0] == 0) {
                break;
            }

            int right = (int) ((Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2)) - Math.pow(triangle[2], 2));
            if(right == 0) {
                buffer.append("right" + "\n");
            } else {
                buffer.append("wrong" + "\n");
            }
        }

        System.out.println(buffer);
    }
}
