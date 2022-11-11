package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hockey_1358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(tokens.nextToken());
        int H = Integer.parseInt(tokens.nextToken());
        int X = Integer.parseInt(tokens.nextToken());
        int Y = Integer.parseInt(tokens.nextToken());
        int P = Integer.parseInt(tokens.nextToken());

        int r = H / 2;
        int count = 0;
        while (P --> 0) {
            tokens = new StringTokenizer(br.readLine());
            int playerX = Integer.parseInt(tokens.nextToken());
            int playerY = Integer.parseInt(tokens.nextToken());

            // 플레이어가 좌측 원에 있을 때
            if (Math.pow((playerX - X), 2) + Math.pow((playerY - (Y + r)), 2) <= Math.pow(r, 2)) {
                count++;
            }
            // 플레이어가 우측 원에 있을 때
            else if (Math.pow((playerX - (X + W)), 2) + Math.pow((playerY - (Y + r)), 2) <= Math.pow(r, 2)) {
                count++;
            }
            // 플레이어가 중앙 사각형에 있을 때
            else if ((playerX >= X && playerX <= X + W) && (playerY >= Y && playerY <= Y + H)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
