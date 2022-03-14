package Baekjoon;

import java.util.Scanner;

public class MovieDirector_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int N = sc.nextInt();
        int num = 665;

        while(count < N) {
            num++;
            if(String.valueOf(num).contains("666")) {
                count++;
                System.out.print(count + "번째 : " + num + " ");
                if(count % 10 == 0) System.out.println();
            }
        }
        System.out.println(num);
    }
}
