package Baekjoon;

/*
    input
    3
    0 0 13 40 0 37
    0 0 3 0 7 4
    1 1 1 1 1 5

    output
    2
    1
    0

    1) 두 원의 중심이 같고, 반지름도 같을 때 (접점의 개수가 무한할 때)
        x1 = x2, y1 = y2, r1 = r2
    2) 접점이 없을 때
        2-1) 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때
            ((x1 - x2)^2 + (y1 - y2)^2).sqrt() > (r1 + r2)

        2-2) 한 원 안에 다른 원이 있으면서 접점이 없을 때
            ((x1 - x2)^2 + (y1 - y2)^2).sqrt() < |r2 - r1|

    3) 접점이 한 개일 때
        3-1) 내접할 때
            ((x1 - x2)^2 + (y1 - y2)^2).sqrt() = |r2 - r1|

        3-2) 외접할 때
            ((x1 - x2)^2 + (y1 - y2)^2).sqrt() = r2 + r1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Turret_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokens = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(tokens.nextToken());
            int y1 = Integer.parseInt(tokens.nextToken());
            int r1 = Integer.parseInt(tokens.nextToken());

            int x2 = Integer.parseInt(tokens.nextToken());
            int y2 = Integer.parseInt(tokens.nextToken());
            int r2 = Integer.parseInt(tokens.nextToken());

            buffer.append(tangent_point(x1, x2, y1, y2, r1, r2)).append("\n");
        }

        System.out.println(buffer);
    }

    public static int tangent_point(int x1, int x2, int y1, int y2, int r1, int r2) {
        int distance_pow = (int)(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

        if (x1 == x2 && y1 == y2 && r1 ==r2) {
            return -1;
        } else if (distance_pow > Math.pow((r1 + r2), 2)) {
            return 0;
        } else if (distance_pow < Math.pow((r1 - r2), 2)) {
            return 0;
        } else if (distance_pow == Math.pow((r1 - r2), 2)) {
            return 1;
        } else if (distance_pow == Math.pow((r1 + r2), 2)) {
            return 1;
        } else {
            return 2;
        }
    }
}
