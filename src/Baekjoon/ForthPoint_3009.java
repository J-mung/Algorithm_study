package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ForthPoint_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dots = new int[4][2];
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int[] dot1 = {Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())};
        tokens = new StringTokenizer(br.readLine());
        int[] dot2 = {Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())};
        tokens = new StringTokenizer(br.readLine());
        int[] dot3 = {Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())};

        /*for (int i = 0; i < 3; i++) {
            tokens = new StringTokenizer(br.readLine());
            dots[i][0] = Integer.parseInt(tokens.nextToken());
            dots[i][1] = Integer.parseInt(tokens.nextToken());
        }*/

        int x, y;

        /*if(dots[0][0] == dots[1][0])
            dots[3][0] = dots[2][0];
        else if(dots[0][0] == dots[2][0])
            dots[3][0] = dots[1][0];
        else
            dots[3][0] = dots[0][0];

        if(dots[0][1] == dots[1][1])
            dots[3][1] = dots[2][1];
        else if(dots[0][1] == dots[2][1])
            dots[3][1] = dots[1][1];
        else
            dots[3][1] = dots[0][1];*/
        if (dot1[0] == dot2[0]) {
            x = dot3[0];
        }
        else if (dot1[0] == dot3[0]) {
            x = dot2[0];
        }
        else {
            x = dot1[0];
        }

        if (dot1[1] == dot2[1]) {
            y = dot3[1];
        }
        else if (dot1[1] == dot3[1]) {
            y = dot2[1];
        }
        else {
            y = dot1[1];
        }

        //System.out.println(dots[3][0] + " " + dots[3][1]);
        System.out.println(x + " " + y);
    }
}
