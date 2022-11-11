package Baekjoon;
/*
    input
    10
    6 3 2 10 10 10 -10 -10 7 3
    8
    10 9 -5 2 3 4 5 -10

    output
    3 0 0 1 2 0 0 2

     0   1  2 3 4 5 6  7  8  9
    -10 -10 2 3 3 6 7 10 10 10
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2_Binary_10816 {
    public static int[] arr;
    public static StringTokenizer cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        N = Integer.parseInt(br.readLine());
        cards = new StringTokenizer(br.readLine());
        solution(N);
    }

    private static void solution(int N) {
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cards.nextToken());

            System.out.print(UpperBound(card) - LowerBound(card) + " ");
        }
    }

    private static int UpperBound(int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if(key < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int LowerBound(int key) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (key <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
