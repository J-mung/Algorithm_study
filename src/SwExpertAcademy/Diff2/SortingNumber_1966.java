package SwExpertAcademy.Diff2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SortingNumber_1966 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        StringBuffer buffer = new StringBuffer();
        int tc = Integer.parseInt(tokens.nextToken());

        for (int i = 0; i < tc; i++) {
            int size = Integer.parseInt(br.readLine());
            arr = new int[size];
            tokens = new StringTokenizer(br.readLine());

            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(tokens.nextToken());
            }

            // sort
            sort();

            buffer.append("#" + (i + 1) + " ");
            for (int j = 0; j < size; j++) {
                buffer.append(arr[j] + " ");
            }

            buffer.append("\n");
        }
        System.out.println(buffer);
    }

    private static void sort() {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }
}
