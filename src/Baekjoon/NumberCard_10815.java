package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard_10815 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer tokens = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        N = Integer.parseInt(br.readLine());
        tokens = new StringTokenizer(br.readLine());
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(tokens.nextToken());
            if(binarySearch(value))
                result.append("1 ");
            else
                result.append("0 ");
        }

        System.out.println(result);
        br.close();
    }

    private static boolean binarySearch(int value) {
        int right = arr.length-1;
        int left = 0;

        while(left <= right) {
            int mid = (right+left)/2;
            if(arr[mid] < value) {
                left = mid + 1;
            } else if (arr[mid] > value){
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
