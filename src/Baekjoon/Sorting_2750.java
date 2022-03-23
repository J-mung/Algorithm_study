package Baekjoon;

import java.util.Scanner;

public class Sorting_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        int temp;

        for(int i = 0; i < length; i++) {
            nums[i] = sc.nextInt();
        }

        for(int i = 0; i < length-1; i++) {
            for(int j = i+1; j < length; j++) {
                if(nums[i] > nums[j]) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for(int val : nums) {
            System.out.println(val);
        }
    }
}
