package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxiGeometry_3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());

        System.out.println(String.format("%.6f", Math.PI * Math.pow(r, 2)));
        System.out.println(String.format("%.6f", (float) 2 * Math.pow(r, 2)));
    }
}